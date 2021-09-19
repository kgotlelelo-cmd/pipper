package com.example.cruisemsdomain.repository;

import static com.example.cruisemsdomain.Util.randomGender;
import static com.example.cruisemsdomain.Util.randomInteger;
import static com.example.cruisemsdomain.Util.randomLong;
import static com.example.cruisemsdomain.Util.randomString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cruisemsdomain.config.TestContainer;
import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.model.Post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class ClientRepositoryTest extends TestContainer {

	@Autowired
	private ClientRepository clientRepository;

	@Test
	public void save_PersistAndReturnAClient_WhenSuccessful() {

		assertNotNull(dbClient);
	}

	private static Client createClient() {
		var post = new Post(randomInteger(), randomString(), randomLong());
		List<Post> posts = List.of(post);

		return new Client(randomString(), randomString(), randomString(), randomString(), randomString(), randomGender(),
				LocalDateTime.now(), posts);
	}
}
