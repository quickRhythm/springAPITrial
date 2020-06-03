package com.example.ornek1;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Slf4j
class Pupulate {

    @Bean
    CommandLineRunner initClients(ClientRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Client("Bilbo Baggins")));
            log.info("Preloading " + repository.save(new Client("Frodo Baggins")));
        };
    }
    @Bean
    CommandLineRunner initAccounts(AccountRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Account(13.99,1)));
            log.info("Preloading " + repository.save(new Account(27.45,1)));
        };
    }
}