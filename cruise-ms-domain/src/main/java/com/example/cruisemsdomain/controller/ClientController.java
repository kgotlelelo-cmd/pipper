package com.example.cruisemsdomain.controller;

import java.util.List;
import java.util.Optional;

import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService service;

    @GetMapping
    public List<Client> fetchAllClients(){
        return service.getAllClients();
    }

    @GetMapping(value ="/{id}")
    public Optional<Client> fetchClientById(@PathVariable Long id){
        return service.findClientById(id);
    }

    @GetMapping(value = "/email/{email}")
    public Optional<Client> fetchClientByEmail(@PathVariable String email){
        return service.findClientByEmail(email);
    }

	  @GetMapping("/name")
    public Optional<Client> fetchClientByUsername(@RequestParam String username){
        return service.findClientByUsername(username);
    }

	  @GetMapping("/{id}/posts")
		public ResponseEntity<List<Post>> getClientPosts(@PathVariable Long id) {
			return ResponseEntity.ok(service.getClientPosts(id));
		}

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Client register(@RequestBody Client newClient){
        return service.saveClient(newClient);
    }

    @DeleteMapping(value = "/{id}")
    void deleteClient(@PathVariable Long id){
        service.deleteClient(id);
    }

    @PutMapping(value = "/{id}")
    Client postStatus(@RequestBody Client newClient,@PathVariable long id){
        return service.updatePost(newClient,id);
    }
}
