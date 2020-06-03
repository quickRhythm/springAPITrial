package com.example.ornek1;

import org.springframework.data.jpa.repository.JpaRepository;

interface ClientRepository extends JpaRepository <Client,Long> {

}
