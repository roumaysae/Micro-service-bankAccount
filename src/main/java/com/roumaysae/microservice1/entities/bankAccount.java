package com.roumaysae.microservice1.entities;

import com.roumaysae.microservice1.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class bankAccount {
    @Id
    private String accountId;
    private Date creationDate;
    private double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
