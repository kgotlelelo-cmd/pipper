package com.example.cruisemsdomain.dummy_data;

import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.model.Gender;
import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class DummyData {

	@Bean
	CommandLineRunner runner(ClientRepository repository){
		return args -> {
			var dummyClient = Client.builder()
				.username("code bender")
				.firstName("kgotlelelo")
				.lastName("masenamela")
				.bio("Have a lovely day")
				.email("kmasenam@student.wethinkcode.co.za")
				.gender(Gender.MALE)
				.dateOfBirth(LocalDateTime.now())
				.posts(List.of(new Post("hello world", 0), new Post("Second", 1)))
				.build();


			var dummyClient2 = Client.builder()
				.username("Don")
				.firstName("John")
				.lastName("Doe")
				.bio("another one")
				.email("kgotlelelomasenamela74@gmail.com")
				.gender(Gender.MALE)
				.dateOfBirth(LocalDateTime.now())
				.build();

			repository.insert(List.of(dummyClient,dummyClient2));
		};
	}
}
