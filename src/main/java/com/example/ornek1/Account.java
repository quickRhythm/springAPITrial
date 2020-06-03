package com.example.ornek1;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
public class Account {
    private @Id
    @GeneratedValue
    long id;
    private double balance;
    private long clientId;


    Account() {}

    Account(double balance, long clientId) {
        this.balance = balance;
        this.clientId = clientId;
    }
}
