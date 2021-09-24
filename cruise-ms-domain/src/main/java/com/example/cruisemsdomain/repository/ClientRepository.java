package com.example.cruisemsdomain.repository;

import com.example.cruisemsdomain.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {

	Optional<Client> findByEmail(String email);

	Optional<Client> findByUsername(String username);
}
