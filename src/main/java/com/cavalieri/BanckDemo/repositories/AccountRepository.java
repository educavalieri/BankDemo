package com.cavalieri.BanckDemo.repositories;

import com.cavalieri.BanckDemo.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
