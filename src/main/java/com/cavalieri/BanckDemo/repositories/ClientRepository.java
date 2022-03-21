package com.cavalieri.BanckDemo.repositories;

import com.cavalieri.BanckDemo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
