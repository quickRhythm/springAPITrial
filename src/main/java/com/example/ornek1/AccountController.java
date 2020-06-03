package com.example.ornek1;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private  AccountRepository repository;
    AccountController (AccountRepository repository){
        this.repository=repository;
    }

    @GetMapping("/accounts")
    List<Account> GetAll(){
        return repository.findAll();
    }

    @PostMapping("/accounts")
    Account Create (@RequestBody Account account){
        //TODO Client'ın mevcut olup olmadığı kontrol edilecek.
        return repository.save(account);
    }

    @PutMapping("/accounts/{id}")
    Account Update (@RequestBody Account account, @PathVariable long id){
        return  repository.findById(id).map(account2Find->{
            account2Find.setBalance(account.getBalance());
            account2Find.setClientId(account.getClientId());
            return repository.save(account2Find);
        }).orElseGet(()->{
            account.setId(id);
            return repository.save(account);
        });
    }
}
