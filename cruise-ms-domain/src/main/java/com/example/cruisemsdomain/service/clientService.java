package com.example.cruisemsdomain.service;


import com.example.cruisemsdomain.Entity.client;
import com.example.cruisemsdomain.repository.clientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class clientService {

    @Autowired
    clientRepository clientRepo;

    //get all clients in the database
    public List<client> getAllClients(){
        return clientRepo.findAll();
    }

    //register a new client into the database
    public client saveClient(client client){
        return clientRepo.insert(client);
    }

    //find client by their id
    public Optional<client> findClientById(String id){
        return clientRepo.findById(id).isPresent() ? clientRepo.findById(id) : Optional.empty();
    }

    //find client by email
    public Optional<client> findClientByEmail(String email){
        return clientRepo.findClientByEmail(email).isPresent() ? clientRepo.findClientByEmail(email) : Optional.empty();
    }


    //find client by username
    public Optional<client> findClientByUsername(String username){
        return clientRepo.findClientByUsername(username).isPresent() ? clientRepo.findClientByUsername(username) : Optional.empty();
    }

    //post a status
    //need fixing
    public client updatePost(client newClient,String id){

        return clientRepo.findById(id)
                .map(client -> {
                    if(client.getPosts()==null){

                    client.setPosts(newClient.getPosts());
                    }
                    else{
                        client.addPost(newClient.getPosts().get(0));
                    }

                    return clientRepo.save(client);
                })
                .orElseThrow(
                        () -> new ExpressionException("Client not found for this id :: " + id)
                );
    }

    public void deleteClient(@PathVariable String id){
        clientRepo.deleteById(id);
    }
}
