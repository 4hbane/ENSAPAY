package com.ENSAPAY.Clientservice.controllers;


import com.ENSAPAY.Clientservice.ExternalServices.User;
import com.ENSAPAY.Clientservice.ExternalServices.authService;
import com.ENSAPAY.Clientservice.entities.CompanyAccount;
import com.ENSAPAY.Clientservice.repositories.CompanyAccountRepository;
import com.ENSAPAY.Clientservice.security.CurrentJWT;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api")
@AllArgsConstructor
public class CompanyAccountController {
    private final CompanyAccountRepository accountRepository;
    private final CurrentJWT currentJWT;
    private final authService authService;

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
    public CompanyAccount saveNewAccount(@RequestBody CompanyAccount companyAccount, HttpServletRequest request){
        CompanyAccount accountCreated = accountRepository.save ( new CompanyAccount ( companyAccount.getName (),companyAccount.getPhoneNumber (),companyAccount.getEmail (),companyAccount.getBalance ())  );
        if (accountCreated != null){ //create his login account
            authService.createUserLogin ( currentJWT.getJWT ( request ), new User (companyAccount.getPhoneNumber (), companyAccount.getName () ));
        }
        return accountCreated;
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
    public void deleteAccount(@PathVariable Long id, HttpServletRequest request){
        if (accountRepository.existsById ( id )) {
            CompanyAccount accountToDelete = accountRepository.findById ( id ).get ();
            accountRepository.deleteById ( id );
            authService.deleteUserLogin ( currentJWT.getJWT ( request ), accountToDelete.getPhoneNumber ()); // delete his login account.
        }
    }

}
