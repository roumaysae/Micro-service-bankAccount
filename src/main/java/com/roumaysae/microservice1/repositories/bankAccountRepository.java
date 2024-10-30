package com.roumaysae.microservice1.repositories;

import com.roumaysae.microservice1.entities.bankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource
public interface bankAccountRepository extends
        JpaRepository<bankAccount, String> {
}
