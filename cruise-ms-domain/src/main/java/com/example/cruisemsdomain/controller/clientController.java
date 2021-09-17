package com.example.cruisemsdomain.controller;

import com.example.cruisemsdomain.Entity.client;
import com.example.cruisemsdomain.service.clientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cruise-ms-domain")
@AllArgsConstructor
public class clientController {

    @Autowired
    private final clientService service;

    @GetMapping(value = "/clients")
    public List<client> fetchAllClients(){
        return service.getAllClients();
    }

    @GetMapping(value ="/client/{id}")
    public Optional<client> fetchClientById(@PathVariable String id){
        return service.findClientById(id);
    }

    @GetMapping(value = "/client/email/{email}")
    public Optional<client> fetchClientByEmail(@PathVariable String email){
        return service.findClientByEmail(email);
    }

    @GetMapping(value = "/client/username/{username}")
    public Optional<client> fetchClientByUsername(@PathVariable String username){
        return service.findClientByUsername(username);
    }

    @PostMapping(value = "/client/register",produces = MediaType.APPLICATION_JSON_VALUE)
    public client register(@RequestBody client newClient){
        return service.saveClient(newClient);
    }

    @DeleteMapping(value = "/client/delete/{id}")
    void deleteClient(@PathVariable String id){
        service.deleteClient(id);
    }

    @PutMapping(value = "/client/post/{id}")
    client postStatus(@RequestBody client newClient,@PathVariable String id){
        return service.updatePost(newClient,id);
    }
}