package com.roumaysae.microservice1.web;
import com.roumaysae.microservice1.repositories.bankAccountRepository;
import com.roumaysae.microservice1.entities.bankAccount;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountRestController {
    private bankAccountRepository bankAccountRepository;

    public AccountRestController(bankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("/bankAccounts")
    public List<bankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public bankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }
    @PostMapping("/bankAccounts")
    public bankAccount save(@RequestBody bankAccount bankAccount1){
        return bankAccountRepository.save(bankAccount1);
    }
    @PutMapping("/bankAccounts/{id}")
    public bankAccount update(@PathVariable String id, @RequestBody bankAccount bankAccount1){
   bankAccount account = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(bankAccount1.getBalance());
        account.setCurrency(bankAccount1.getCurrency());
        account.setAccountType(bankAccount1.getAccountType());
        return bankAccountRepository.save(account);
    }
}
