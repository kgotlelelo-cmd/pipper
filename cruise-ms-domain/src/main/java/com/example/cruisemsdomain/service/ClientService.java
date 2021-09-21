package com.example.cruisemsdomain.service;

import java.util.List;
import java.util.Optional;

import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepo;

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

	//find client by their id and return their posts
		public List<Post> getClientPosts(Long id) {
			return findClientById(id).get().getPosts();
		}

    //find client by email
//    public Optional<Client> findClientByEmail(String email){
//        return clientRepo.findClientByEmail(email).isPresent() ? clientRepo.findClientByEmail(email) : Optional.empty();
//    }


    //find client by username
//    public Optional<Client> findClientByUsername(String username){
//        return clientRepo.findClientByUsername(username).isPresent() ? clientRepo.findClientByUsername(username) : Optional.empty();
//    }

    //post a status
    //need fixing
    public Client updatePost(Client newClient,Long id){

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
}
