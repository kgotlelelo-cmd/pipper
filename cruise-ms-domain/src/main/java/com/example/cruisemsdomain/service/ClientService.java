package com.example.cruisemsdomain.service;

import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.repository.ClientRepository;
import com.example.cruisemsdomain.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepo;

    @Autowired
    PostRepository postRepo;

    //get all clients in the database
    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }

    //register a new client into the database
    public Client saveClient(Client client){
        return clientRepo.save(client);
    }

    //find client by their id
    public Optional<Client> findClientById(Long id){
        return clientRepo.findById(id).isPresent() ? clientRepo.findById(id) : Optional.empty();
    }

    //find client by email
    public Optional<Client> findByEmail(String email){
        return clientRepo.findByEmail(email).isPresent() ? clientRepo.findByEmail(email) : Optional.empty();
    }


    //post a status
    //need fixing
    public Client addPost(Client newClient,Long id){

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

    public void deleteClient(@PathVariable Long id){
        clientRepo.deleteById(id);
    }

    //Start of the post service functions

    public Optional<Post> findPostById(Long id){
        return postRepo.findById(id).isPresent() ? postRepo.findById(id):Optional.empty();
    }

    public List<Post> getAllPosts(){
        return postRepo.findAll();
    }

    public void deletePostById(Long id){
        postRepo.deleteById(id);
    }
}
