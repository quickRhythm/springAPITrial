package com.example.ornek1;

import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
public class ClientController {
    ClientRepository repository;

    ClientController(ClientRepository clientRepository) {
        this.repository = clientRepository;
    }

    @GetMapping("/clients")
    List<Client> GetAll() {
        return repository.findAll();
    }

    @PostMapping("/clients")
    Client Create(@RequestBody Client client) {
        return repository.save(client);
    }

    @PutMapping("/clients/{id}")
    Client Update(@RequestBody Client client, @PathVariable long id) {
        return repository.findById(id).map(client2Update -> {
            client2Update.setName(client.getName());
            return repository.save(client2Update);
        }).orElseGet(() -> {
            client.setId(id);
            return repository.save(client);
        });
    }
}
