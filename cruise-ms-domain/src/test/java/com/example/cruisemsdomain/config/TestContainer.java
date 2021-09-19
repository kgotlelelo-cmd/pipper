package com.example.cruisemsdomain.config;

import java.time.Duration;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public abstract class TestContainer {

	private static final String MONGO_IMAGE = "mongo:4.2.16";
	private static final Integer MONGO_PORT = 27017;

	private static final GenericContainer<?> container;

	static {
		container = new GenericContainer<>(DockerImageName.parse(MONGO_IMAGE));

		container.withReuse(true);
		container.withExposedPorts(MONGO_PORT);
		container.withEnv("MONGO_INITDB_ROOT_USERNAME", "TEST");
		container.withEnv("MONGO_INITDB_ROOT_PASSWORD", "TEST");
		container.withEnv("MONGO_INITDB_DATABASE", "TEST");
		
		container.setWaitStrategy(Wait.forListeningPort().withStartupTimeout(Duration.ofMinutes(1)));
		container.start();
	}

	@DynamicPropertySource
	static void mongoProperties(DynamicPropertyRegistry registry) {
		//	registry.add("spring.data.mongodb.uri", mongoContainer::getReplicaSetUrl);

		registry.add("spring.data.mongodb.host", container::getHost);
		registry.add("spring.data.mongodb.port", () -> container.getMappedPort(MONGO_PORT));
		registry.add("spring.data.mongodb.username", () -> "TEST");
		registry.add("spring.data.mongodb.password", () -> "TEST");
		registry.add("spring.data.mongodb.database", () -> "TEST");
	}
}
