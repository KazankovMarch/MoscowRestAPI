package ru.adkazankov.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.adkazankov.dao.ClientRepository;
import ru.adkazankov.domain.Client;

import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping("/{id}")
    Optional<Client> getClient(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    @PostMapping
    Optional<Client> saveClient(@RequestBody Client client){
        return Optional.of(repository.save(client));
    }

    @PutMapping
    Optional<Client> updatePassword(@RequestBody Client client){
        if(client.getLogin()==null || client.getLogin().equals("")|| client.getPassword()==null || client.getPassword().equals("")){
            return null; }
        Optional<Client> res = Optional.empty();
        if(client.getId()!=null) {
            if(repository.findById(client.getId()).isPresent()) {
                res = Optional.of(repository.save(client));
            }
        }
        else {
            Optional<Client> optionalOldClient = repository.findClientByLogin(client.getLogin());
            if(optionalOldClient.isPresent()){
                client.setId(optionalOldClient.get().getId());
                res = Optional.of(repository.save(client));
            }
        }
        return res;
    }

    @DeleteMapping("/{id}")
    Boolean deleteClient(@PathVariable("id") Long id){
        try {
            repository.deleteById(id);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    @DeleteMapping
    Boolean deleteClient(@RequestBody Client client){
        Optional<Client> oldClient = repository.findClientByLogin(client.getLogin());
        if(oldClient.isPresent() && oldClient.get().equals(client)){
            repository.delete(client);
            return true;
        }
        return false;
    }



}
