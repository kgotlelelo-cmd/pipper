package com.example.cruisemsdomain.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cruisemsdomain.config.TestContainer;
import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.model.Gender;
import com.example.cruisemsdomain.model.Post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class ClientRepositoryTest extends TestContainer {
	
	private static final Client staticClient = createClient();

	@Autowired
	private ClientRepository clientRepository;

	@Test
	public void save_PersistAndReturnAClient_WhenSuccessful() {
		var dbClient = clientRepository.save(staticClient);

		assertNotNull(dbClient);
		assertEquals(dbClient.getId(), staticClient.getId());
	}

	private static Client createClient() {
		List<Post> posts = List.of();
		return new Client("id", "name", "lastname", "bio", "email", Gender.MALE, LocalDateTime.now(), posts);
	}
}
