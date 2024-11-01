package com.roumaysae.microservice1.web;
import com.roumaysae.microservice1.repositories.bankAccountRepository;
import com.roumaysae.microservice1.entities.bankAccount;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController

@RequestMapping("/api")
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
       if(bankAccount1.getAccountId()!=null){
           bankAccount1.setAccountId(UUID.randomUUID().toString());
       }
        return bankAccountRepository.save(bankAccount1);
    }

    @PutMapping("/bankAccounts/{id}")
    public bankAccount update(@PathVariable String id, @RequestBody bankAccount bankAccount1){
   bankAccount account = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
     if(bankAccount1.getBalance()!= null){
         account.setBalance(bankAccount1.getBalance());
     }
        if(bankAccount1.getCreationDate()!= null)  account.setCreationDate(bankAccount1.getCreationDate());
        if(bankAccount1.getCurrency()!= null)      account.setCurrency(bankAccount1.getCurrency());
        if(bankAccount1.getAccountType()!= null)  account.setAccountType(bankAccount1.getAccountType());
        return bankAccountRepository.save(account);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id){
         bankAccountRepository.deleteById(id);
    }

}
