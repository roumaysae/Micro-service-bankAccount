package com.roumaysae.microservice1;

import com.roumaysae.microservice1.entities.bankAccount;
import com.roumaysae.microservice1.enums.AccountType;
import com.roumaysae.microservice1.repositories.bankAccountRepository;
import lombok.Builder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class MicroService1Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroService1Application.class, args);

    }
    @Builder
   @Bean
    CommandLineRunner start(bankAccountRepository bankAccountRepository) {
       return args -> {
           for (int i = 0; i < 10; i++) {
bankAccount account = bankAccount.builder()
        .accountId(UUID.randomUUID().toString())
        .creationDate(new Date())
        .balance(1000 + Math.random() * 9000)
        .currency("EUR")
        .accountType(AccountType.SAVING_Account)
        .build();
               bankAccountRepository.save(account);
             //that's or this way(both are good
//bankAccountRepository.save(new bankAccount(null, new Date(), 1000 + Math.random() * 9000, "EUR", AccountType.SAVING_Account));
           }

       };
   }

}
