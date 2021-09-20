package com.example.cruisemsdomain.repository;

import static com.example.cruisemsdomain.Util.randomGender;
import static com.example.cruisemsdomain.Util.randomInteger;
import static com.example.cruisemsdomain.Util.randomLong;
import static com.example.cruisemsdomain.Util.randomString;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cruisemsdomain.config.TestContainer;
import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.model.Post;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class ClientRepositoryTest extends TestContainer {

	private static final Client CLIENT = createClient();

	@Autowired
	private ClientRepository clientRepository;

	@AfterEach
	public void deleteAfterTest(){
		clientRepository.deleteAll();
	}

	@Test
	public void save_PersistAndReturnAClient_WhenSuccessful() {
		var dbClient = clientRepository.save(CLIENT);

		assertNotNull(CLIENT);
		assertNotNull(dbClient);
		assertEquals(dbClient.getId(), CLIENT.getId());
	}

	@Test
	public void save_ThrownIllegalArgumentException_WhenClientIsNull() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> clientRepository.save(null));
	}

	@Test
	public void save_NoExceptionIsThrowed_WhenClientIsEmpty() {
		assertDoesNotThrow(() -> clientRepository.save(new Client()));
	}

	@Test
	public void save_NoExceptionIsThrowed_WhenPostListIsNull() {
		var client = createClient();
		client.setPosts(null);

		assertDoesNotThrow(() -> clientRepository.save(client));
	}

	@Test
	public void save_NoExceptionIsThrowed_WhenPostListIsEmpty() {
		var client = createClient();
		client.setPosts(List.of());

		assertDoesNotThrow(() -> clientRepository.save(client));
	}

	@Test
	public void findClientByEmail_ReturnAPresentOptionalOfClient_WhenAPersistedClientHasTheSpecifiedEmail(){
		var email = "EMAIL_FOR_TEST";
		clientRepository.save(createClientWithSpecificEmail(email));

		var clientDB = clientRepository.findByEmail(email);

		assertNotNull(clientDB);
		assertTrue(clientDB.isPresent());
		assertEquals(clientDB.get().getEmail(), email);
	}

	@Test
	public void findClientByEmail_NoExceptionIsThrowed_WhenEmailIsEmpty() {
		assertDoesNotThrow(() -> clientRepository.findByEmail(""));
	}

	/*
	 * Nulls should be avoided in the service layer.
	 */
	@Test
	public void findClientByEmail_NoExceptionIsThrowed_WhenEmailIsNull() {
		assertDoesNotThrow(() -> clientRepository.findByEmail(null));
	}

	@Test
	public void findClientByUsername_ReturnAPresentOptionalOfClient_WhenAPersistedClientHasTheSpecifiedUsername(){
		var username = "USERNAME_FOR_TEST";
		clientRepository.save(createClientWithSpecificUsername(username));

		var clientDB = clientRepository.findByUsername(username);

		assertNotNull(clientDB);
		assertTrue(clientDB.isPresent());
		assertEquals(clientDB.get().getUsername(), username);
	}

	@Test
	public void findClientByUsername_NoExceptionIsThrowed_WhenUsernameIsEmpty() {
		assertDoesNotThrow(() -> clientRepository.findByUsername(""));
	}

	/*
	 * Nulls should be avoided in the service layer.
	 */
	@Test
	public void findClientByUsername_NoExceptionIsThrowed_WhenUsernameIsNull() {
		assertDoesNotThrow(() -> clientRepository.findByUsername(null));
	}

	//temporal
	private static Client createClientWithSpecificEmail(String email){
		var client = createClient();
		client.setEmail(email);
		return client;
	}

	//temporal
	private static Client createClientWithSpecificUsername(String username){
		var client = createClient();
		client.setUsername(username);
		return client;
	}

	private static Client createClient() {
		var post = new Post(randomInteger(), randomString(), randomLong());
		List<Post> posts = List.of(post);

		return new Client(randomString(), randomString(), randomString(), randomString(), randomString(), randomGender(),
				LocalDateTime.now(), posts);
	}
}
