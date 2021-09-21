package com.example.cruisemsdomain.dummy_data;

import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.model.Gender;
import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DummyData {

	@Bean
	CommandLineRunner runner(ClientRepository repository) {
		return args -> {
			var dummyClient = Client.builder()
				.username("code bender")
				.firstName("kgotlelelo")
				.lastName("masenamela")
				.bio("Have a lovely day")
				.email("kmasenam@student.wethinkcode.co.za")
				.gender(Gender.MALE)
				.dateOfBirth(LocalDateTime.now())
				.build();
			dummyClient.addPost(Post.builder().body("hello world").likes(0L).build());

			var dummy1Client = Client.builder()
				.username("Don")
				.firstName("John")
				.lastName("Doe")
				.bio("another one")
				.email("kgotlelelomasenamela74@gmail.com")
				.gender(Gender.MALE)
				.dateOfBirth(LocalDateTime.now())
				.build();
			dummy1Client.addPost(Post.builder().body("a post").likes(0L).build());

			repository.save(dummyClient);
			repository.save(dummy1Client);
		};
	}
}
