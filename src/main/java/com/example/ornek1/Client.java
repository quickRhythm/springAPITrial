package com.example.ornek1;

import lombok.Data;
import com.example.ornek1.Account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
class Client {

    private @Id @GeneratedValue long id;
    private String name;


    Client(){}

    Client (String name){
        this.name=name;

    }
}
