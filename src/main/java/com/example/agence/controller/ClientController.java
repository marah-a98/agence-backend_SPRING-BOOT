package com.example.agence.controller;


import com.example.agence.model.Client;
import com.example.agence.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @PostMapping("/client/save")
    public Client save(@RequestBody Client client){
        return clientRepository.save(client);
    }

    @GetMapping("/client/{id}")
    public Client getById(@PathVariable Long id){

        return clientRepository.findById(id).orElse(null);
    }

    @PutMapping("/client/{id}")
    public  Client update(@PathVariable Long id, @RequestBody Client client){
        client.setId(id);
        Client oldClient = clientRepository.findById(id).orElse(null);
        client.setFirstname(client.getFirstname()==null?oldClient.getFirstname():client.getFirstname());
        client.setLastname(client.getLastname()==null?oldClient.getLastname():client.getLastname());
        client.setEmail(client.getEmail()==null?oldClient.getEmail():client.getEmail());
        client.setPassword(client.getPassword()==null?oldClient.getPassword():client.getPassword());
        client.setMobile(client.getMobile()==null?oldClient.getMobile():client.getMobile());
        return clientRepository.save(client);
    }

    @DeleteMapping("/clientdelet/{id}")
    public void delete(@PathVariable Long id){
        clientRepository.deleteById(id);
    }
}
