package com.roumaysae.microservice1.repositories;

import com.roumaysae.microservice1.entities.bankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bankAccountRepository extends
        JpaRepository<bankAccount, String> {
}
