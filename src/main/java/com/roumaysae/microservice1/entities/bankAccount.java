package com.roumaysae.microservice1.entities;

import com.roumaysae.microservice1.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.awt.geom.GeneralPath;
import java.util.Date;
import java.util.UUID;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class bankAccount {
    @Id
    private String accountId;
    private Date creationDate;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
