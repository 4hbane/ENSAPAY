package com.ENSAPAY.Clientservice.controllers;


import com.ENSAPAY.Clientservice.entities.PersonalAccount;
import com.ENSAPAY.Clientservice.repositories.PersonalAccountRepository;
import com.ENSAPAY.Clientservice.services.Bill;
import com.ENSAPAY.Clientservice.services.Payement;
import com.ENSAPAY.Clientservice.services.PayementImplementation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
@AllArgsConstructor
public class PersonalAccountController {
    private final PersonalAccountRepository accountRepository;
    private final Payement payement;

    @GetMapping("/personalAccounts")
    public List<PersonalAccount> getPersonalAccounts(){
        return accountRepository.findAll ();
    }
    @GetMapping("/personalAccounts/{id}")
    public Optional<PersonalAccount> getAccountById(@PathVariable Long id){
        return accountRepository.findById ( id );
    }
    @GetMapping("/personalAccounts/accountNumber/{accountNumber}")
    public Optional<PersonalAccount> getAccountByAccountNumber(@PathVariable String accountNumber){
        return accountRepository.findByAccountNumber ( accountNumber );
    }
    @GetMapping("/personalAccounts/phoneNumber/{phoneNumber}")
    public Optional<PersonalAccount> getAccountByName(@PathVariable String phoneNumber){
        return accountRepository.findByPhoneNumber(phoneNumber);
    }

    @PostMapping("/personalAccounts")
    public PersonalAccount saveNewAccount(@RequestBody PersonalAccount personalAccount){
        return accountRepository.save ( new PersonalAccount (personalAccount.getFirstName (), personalAccount.getLastName (),personalAccount.getCin (),personalAccount.getPhoneNumber (),personalAccount.getEmail (),personalAccount.getBalance ()) );
    }

    @PutMapping("/personalAccounts/{id}")
    public PersonalAccount saveNewAccount(@RequestBody PersonalAccount personalAccount, @PathVariable Long id){
        if (accountRepository.existsById ( id )) {
            PersonalAccount beforeUpdate = accountRepository.findById ( id ).get ();
            personalAccount.setId ( id );
            personalAccount.setCin ( beforeUpdate.getCin () );
            personalAccount.setAccountNumber ( beforeUpdate.getAccountNumber () );
            personalAccount.setCreationDate ( beforeUpdate.getCreationDate () );

            return accountRepository.save ( personalAccount );
        }
        return null;
    }

    @DeleteMapping("/personalAccounts/{id}")
    public void deleteAccount(@PathVariable Long id){
        if (accountRepository.existsById ( id )) {
             accountRepository.deleteById ( id );
        }
    }

    @PostMapping("/personalAccounts/makePayement")
    public Boolean makePayment(@RequestBody Bill bill){
          return payement.makePayment ( bill );
    }
}
