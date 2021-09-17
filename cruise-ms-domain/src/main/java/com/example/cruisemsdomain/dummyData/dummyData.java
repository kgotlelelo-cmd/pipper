package com.example.cruisemsdomain.dummyData;

import com.example.cruisemsdomain.Entity.client;
import com.example.cruisemsdomain.model.Gender;
import com.example.cruisemsdomain.model.post;
import com.example.cruisemsdomain.repository.clientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class dummyData {
    @Bean
    CommandLineRunner runner(clientRepository repository){
        return args -> {
            client dummyClient = new client(
                    "code bender",
                    "kgotlelelo",
                    "masenamela",
                    "Have a lovely day",
                    "kmasenam@student.wethinkcode.co.za",
                    Gender.MALE,
                    LocalDateTime.now(),
                    List.of(new post(
                            "hello world",
                            0
                    ))
            );

            client dummy1Client = new client(
                    "Don",
                    "John",
                    "Doe",
                    "another one",
                    "kgotlelelomasenamela74@gmail.com",
                    Gender.FEMALE,
                    LocalDateTime.now()
            );

            repository.insert(List.of(dummyClient,dummy1Client));
        };
    }
}