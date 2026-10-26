package com.example.demo.service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SpringTopicsService {
	private final List<Topic> topics = List.of(
			new Topic("Spring Core", "Spring Core provides the foundation of the framework, including the IoC container that creates and manages application objects (beans)."),
			new Topic("Dependency Injection", "Dependency Injection supplies an object with the collaborators it needs instead of having it construct them. Spring commonly wires dependencies through constructors, which makes dependencies explicit and supports testing."),
			new Topic("Spring Boot", "Spring Boot makes Spring applications quicker to create and run. It provides opinionated auto-configuration, starter dependencies, and production-ready features such as health and metrics integrations."),
			new Topic("Spring MVC", "Spring MVC is Spring's servlet-based web framework. Controllers map HTTP requests to handler methods, and the framework converts request data and return values."),
			new Topic("REST APIs", "Spring REST APIs use Spring MVC controllers to expose HTTP resources. Annotations such as @RestController, @GetMapping, and @RequestBody map requests and responses, commonly using JSON."),
			new Topic("Spring Data JPA", "Spring Data JPA simplifies persistence with repository interfaces backed by JPA. It can generate common data-access operations and supports custom queries and pagination."),
			new Topic("Spring Security", "Spring Security provides authentication, authorization, and protection against common web security risks. Its filter chain applies security rules to incoming requests."),
			new Topic("Spring AOP", "Spring AOP implements cross-cutting behavior, such as logging or method-level security, using aspects that run around selected method executions."),
			new Topic("Transactions", "Spring transaction management groups operations into a unit of work. Declarative transactions are commonly configured with @Transactional and coordinated by a transaction manager."),
			new Topic("Spring Testing", "Spring testing support integrates with JUnit and provides test utilities for application contexts, MVC endpoints, and slices of an application."));

	public List<Topic> listTopics() {
		return topics;
	}

	public Optional<Topic> findTopic(String name) {
		if (name == null || name.isBlank()) {
			return Optional.empty();
		}

		String normalizedName = normalize(name);
		return topics.stream()
				.filter(topic -> normalize(topic.name()).equals(normalizedName))
				.findFirst();
	}

	private String normalize(String value) {
		return value.trim().toLowerCase(Locale.ROOT).replace('-', ' ').replace('_', ' ');
	}

	public record Topic(String name, String description) {
	}
}
