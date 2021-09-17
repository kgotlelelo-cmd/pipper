package com.example.cruisemsdomain.repository;

import com.example.cruisemsdomain.Entity.client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface clientRepository extends MongoRepository<client,String> {

    @Query("{ 'email' : ?0 }")
    Optional<client> findClientByEmail(String email);


    @Query("{ 'username' : ?0 }")
    Optional<client> findClientByUsername(String username);
}
