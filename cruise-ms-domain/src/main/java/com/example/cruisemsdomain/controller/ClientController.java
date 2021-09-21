package com.example.cruisemsdomain.controller;

import com.example.cruisemsdomain.entity.Client;
import com.example.cruisemsdomain.entity.Post;
import com.example.cruisemsdomain.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cruise-ms-domain")
@AllArgsConstructor
public class ClientController {

    @Autowired
    private final ClientService service;

    @GetMapping(value = "/clients")
    public List<Client> fetchAllClients(){
        return service.getAllClients();
    }

    @GetMapping(value ="/client/{id}")
    public Optional<Client> fetchClientById(@PathVariable Long id){
        return service.findClientById(id);
    }

    @GetMapping(value = "/client/email/{email}")
    public Optional<Client> fetchClientByEmail(@PathVariable String email){
        return service.findClientByEmail(email);
    }

    @GetMapping(value = "/client/username/{username}")
    public Optional<Client> fetchClientByUsername(@PathVariable String username){
        return service.findClientByUsername(username);
    }

	  @GetMapping("/client/{id}/posts")
		public ResponseEntity<List<Post>> getClientPosts(@PathVariable Long id) {
			return ResponseEntity.ok(service.getClientPosts(id));
		}

    @PostMapping(value = "/client/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public Client register(@RequestBody Client newClient){
        return service.saveClient(newClient);
    }

    @DeleteMapping(value = "/client/delete/{id}")
    void deleteClient(@PathVariable Long id){
        service.deleteClient(id);
    }

    @PutMapping(value = "/client/post/{id}")
    Client postStatus(@RequestBody Client newClient,@PathVariable long id){
        return service.updatePost(newClient,id);
    }
}
