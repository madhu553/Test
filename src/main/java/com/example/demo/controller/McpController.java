package com.example.demo.controller;

import com.example.demo.service.SpringTopicsService;
import com.example.demo.service.SpringTopicsService.Topic;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.JsonNode;

@RestController
public class McpController {
	private final SpringTopicsService springTopicsService;

	public McpController(SpringTopicsService springTopicsService) {
		this.springTopicsService = springTopicsService;
	}

	@PostMapping(path = "/MCP", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> handle(@RequestBody JsonNode request) {
		if (!request.isObject()
				|| !request.path("jsonrpc").asText().equals("2.0")
				|| !request.path("method").isTextual()) {
			return ResponseEntity.ok(error(null, -32600, "Invalid Request"));
		}

		JsonNode id = request.get("id");
		if (id == null) {
			return ResponseEntity.accepted().build();
		}

		return ResponseEntity.ok(dispatch(id, request.path("method").asText(), request.path("params")));
	}

	private Map<String, Object> dispatch(JsonNode id, String method, JsonNode params) {
		return switch (method) {
			case "initialize" -> success(id, Map.of(
					"protocolVersion", "2025-03-26",
					"capabilities", Map.of("tools", Map.of("listChanged", false)),
					"serverInfo", Map.of("name", "spring-topics-server", "version", "1.0.0")));
			case "ping" -> success(id, Map.of());
			case "tools/list" -> success(id, Map.of("tools", toolDefinitions()));
			case "tools/call" -> success(id, callTool(params));
			default -> error(id, -32601, "Method not found");
		};
	}

	private List<Map<String, Object>> toolDefinitions() {
		return List.of(
				Map.of(
						"name", "list_spring_topics",
						"description", "List the Spring framework topics available for explanation.",
						"inputSchema", Map.of("type", "object", "properties", Map.of())),
				Map.of(
						"name", "explain_spring_topic",
						"description", "Get a concise explanation of a Spring framework topic.",
						"inputSchema", Map.of(
								"type", "object",
								"properties", Map.of("topic", Map.of(
										"type", "string",
										"description", "Topic name, for example Spring Boot or Spring Security")),
								"required", List.of("topic"))));
	}

	private Map<String, Object> callTool(JsonNode params) {
		if (!params.isObject() || !params.path("name").isTextual()) {
			return toolError("Tool name is required.");
		}

		String name = params.path("name").asText();
		JsonNode arguments = params.path("arguments");
		return switch (name) {
			case "list_spring_topics" -> toolResult(formatTopics());
			case "explain_spring_topic" -> explainTopic(arguments);
			default -> toolError("Unknown tool: " + name);
		};
	}

	private Map<String, Object> explainTopic(JsonNode arguments) {
		JsonNode topicName = arguments.path("topic");
		if (!topicName.isTextual() || topicName.asText().isBlank()) {
			return toolError("A non-empty topic name is required.");
		}

		return springTopicsService.findTopic(topicName.asText())
				.map(topic -> toolResult(topic.name() + ": " + topic.description()))
				.orElseGet(() -> toolError("No matching Spring topic found. Use list_spring_topics to see available topics."));
	}

	private String formatTopics() {
		return springTopicsService.listTopics().stream()
				.map(topic -> topic.name() + ": " + topic.description())
				.reduce((first, second) -> first + "\n\n" + second)
				.orElse("");
	}

	private Map<String, Object> toolResult(String text) {
		return Map.of("content", List.of(Map.of("type", "text", "text", text)), "isError", false);
	}

	private Map<String, Object> toolError(String message) {
		return Map.of("content", List.of(Map.of("type", "text", "text", message)), "isError", true);
	}

	private Map<String, Object> success(JsonNode id, Map<String, Object> result) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("jsonrpc", "2.0");
		response.put("id", id);
		response.put("result", result);
		return response;
	}

	private Map<String, Object> error(JsonNode id, int code, String message) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("jsonrpc", "2.0");
		response.put("id", id);
		response.put("error", Map.of("code", code, "message", message));
		return response;
	}
}
