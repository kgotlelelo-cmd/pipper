package com.example.cruisemsdomain.repository;

import static com.example.cruisemsdomain.Util.randomGender;
import static com.example.cruisemsdomain.Util.randomLong;
import static com.example.cruisemsdomain.Util.randomString;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.entity.Post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Transactional
public class ClientRepositoryTest {

	private static final Client CLIENT = createClient();

	@Autowired
	private ClientRepository clientRepository;

	//@AfterEach
	//public void deleteArterTest(){
	//	clientRepository.deleteAll();
	//}

	@Test
	public void save_PersistAndReturnAClient_WhenSuccessful() {
		var dbClient = clientRepository.save(CLIENT);

		assertNotNull(CLIENT);
		assertNotNull(dbClient);
		assertEquals(dbClient.getId(), CLIENT.getId());
	}

	@Test
	public void save_ThrownInvalidDataAccessApiUsageException_WhenClientIsNull() {
		assertThatExceptionOfType(InvalidDataAccessApiUsageException.class).isThrownBy(() -> clientRepository.save(null));
	}

	@Test
	public void save_ThrownDataIntegrityViolationException_WhenClientIsEmpty() {
		assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy(() -> clientRepository.save(new Client()));
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
	public void findByEmail_ReturnAPresentOptionalOfClient_WhenAPersistedClientHasTheSpecifiedEmail(){
		var email = "EMAIL_FOR_TEST";
		clientRepository.save(createClientWithSpecificEmail(email));

		var clientDB = clientRepository.findByEmail(email);

		assertNotNull(clientDB);
		assertTrue(clientDB.isPresent());
		assertEquals(clientDB.get().getEmail(), email);
	}

	@Test
	public void findByEmail_ReturnAnEmptyOptional_WhenEmailIsEmpty() {
		var clientDB = clientRepository.findByEmail("");

		assertTrue(clientDB.isEmpty());
	}

	/*
	 * Nulls should be avoided in the service layer.
	 */
	@Test
	public void findByEmail_ReturnAnEmptyOptional_WhenEmailIsNull() {
		var clientDB = clientRepository.findByEmail(null);

		assertTrue(clientDB.isEmpty());
	}

	@Test
	public void findByUsername_ReturnAPresentOptionalOfClient_WhenAPersistedClientHasTheSpecifiedUsername(){
		var username = "USERNAME_FOR_TEST";
		clientRepository.save(createClientWithSpecificUsername(username));

		var clientDB = clientRepository.findByUsername(username);

		assertNotNull(clientDB);
		assertTrue(clientDB.isPresent());
		assertEquals(clientDB.get().getUsername(), username);
	}

	@Test
	public void findByUsername_ReturnAnEmptyOptional_WhenEmailIsEmpty() {
		var clientDB = clientRepository.findByUsername("");

		assertTrue(clientDB.isEmpty());
	}

	/*
	 * Nulls should be avoided in the service layer.
	 */
	@Test
	public void findByUsername_ReturnAnEmptyOptional_WhenEmailIsNull() {
		var clientDB = clientRepository.findByUsername(null);

		assertTrue(clientDB.isEmpty());
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
		var client = Client.builder()
			.username(randomString())
			.firstName(randomString())
			.lastName(randomString())
			.bio(randomString())
			.email(randomString())
			.gender(randomGender())
			.dateOfBirth(LocalDateTime.now())
			.build();

		client.addPost(Post.builder().body(randomString()).likes(randomLong()).build());
		return client;
	}
}
