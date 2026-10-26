package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@Test
	void initializesMcpServer() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/MCP")
						.contentType("application/json")
						.content("""
								{"jsonrpc":"2.0","id":1,"method":"initialize","params":{"protocolVersion":"2025-03-26","capabilities":{},"clientInfo":{"name":"test-client","version":"1.0"}}}
								"""))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.serverInfo.name")
						.value("spring-topics-server"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.capabilities.tools")
						.exists());
	}

	@Test
	void listsAndExplainsSpringTopics() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/MCP")
						.contentType("application/json")
						.content("""
								{"jsonrpc":"2.0","id":2,"method":"tools/call","params":{"name":"explain_spring_topic","arguments":{"topic":"spring-boot"}}}
								"""))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.isError")
						.value(false))
				.andExpect(MockMvcResultMatchers.jsonPath("$.result.content[0].text")
						.value(org.hamcrest.Matchers.containsString("Spring Boot")));
	}

	@Test
	void preservesExistingSumEndpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/sum")
						.param("first", "2")
						.param("second", "3"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("5"));
	}
}
