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
            Client dummyClient = new Client(
                    "code bender",
                    "kgotlelelo",
                    "masenamela",
                    "Have a lovely day",
                    "kmasenam@student.wethinkcode.co.za",
                    Gender.MALE,
                    LocalDateTime.now(),
                    List.of(new Post(
                            "hello world",
                            0
                    ))
            );

            Client dummy1Client = new Client(
                    "Don",
                    "John",
                    "Doe",
                    "another one",
                    "kgotlelelomasenamela74@gmail.com",
                    Gender.FEMALE,
                    LocalDateTime.now()
            );

            repository.saveAll(List.of(dummyClient,dummy1Client));
        };
    }
}
