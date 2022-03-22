package com.cavalieri.BanckDemo.repositories;

import com.cavalieri.BanckDemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String name);
}
