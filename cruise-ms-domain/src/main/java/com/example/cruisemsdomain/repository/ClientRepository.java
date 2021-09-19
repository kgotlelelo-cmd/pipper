package com.example.cruisemsdomain.repository;

import com.example.cruisemsdomain.entity.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client,String> {

    @Query("{ 'email' : ?0 }")
    Optional<Client> findClientByEmail(String email);


    @Query("{ 'username' : ?0 }")
    Optional<Client> findClientByUsername(String username);
}
