package com.ENSAPAY.Clientservice.controllers;


import com.ENSAPAY.Clientservice.entities.CompanyAccount;
import com.ENSAPAY.Clientservice.repositories.CompanyAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
@AllArgsConstructor
public class CompanyAccountController {
    private final CompanyAccountRepository accountRepository;

    @GetMapping("companiesAccounts")
    public List<CompanyAccount> getCompanyAccounts(){
        return accountRepository.findAll ();
    }
    @GetMapping("companiesAccounts/{id}")
    public Optional<CompanyAccount> getAccountById(@PathVariable Long id){
        return accountRepository.findById ( id );
    }
    @GetMapping("companiesAccounts/accountNumber/{accountNumber}")
    public Optional<CompanyAccount> getAccountByAccountNumber(@PathVariable String accountNumber){
        return accountRepository.findByAccountNumber ( accountNumber );
    }
    @GetMapping("companiesAccounts/phoneNumber/{phoneNumber}")
    public Optional<CompanyAccount> getAccountByName(@PathVariable String phoneNumber){
        return accountRepository.findByPhoneNumber(phoneNumber);
    }

    @PostMapping("/companiesAccounts")
    public CompanyAccount saveNewAccount(@RequestBody CompanyAccount companyAccount){
        return accountRepository.save ( new CompanyAccount ( companyAccount.getName (),companyAccount.getPhoneNumber (),companyAccount.getEmail (),companyAccount.getBalance ())  );
    }

    @PutMapping("/companiesAccounts/{id}")
    public CompanyAccount saveNewAccount(@RequestBody CompanyAccount companyAccount, @PathVariable Long id){
        if (accountRepository.existsById ( id )) {
            CompanyAccount beforeUpdate = accountRepository.findById ( id ).get ();
            companyAccount.setId ( id );
            companyAccount.setAccountNumber ( beforeUpdate.getAccountNumber () );
            companyAccount.setCreationDate ( beforeUpdate.getCreationDate () );

            return accountRepository.save ( companyAccount );
        }
        return null;
    }

    @DeleteMapping("/companiesAccounts/{id}")
    public void deleteAccount(@PathVariable Long id){
        if (accountRepository.existsById ( id )) {
            accountRepository.deleteById ( id );
        }
    }

}
