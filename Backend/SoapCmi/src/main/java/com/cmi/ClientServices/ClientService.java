package com.cmi.ClientServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Service
@FeignClient(name = "CLIENT-SERVICE")
public interface ClientService {
    @GetMapping("/api/personalAccounts/accountNumber/{accountNumber}")
    public Optional<PersonalAccount> getPersonalAccountByAccountNumber(@PathVariable String accountNumber);

    @GetMapping("/api/personalAccounts/phoneNumber/{phoneNumber}")
    public Optional<PersonalAccount> getPersonalAccountPhoneNumber(@PathVariable String phoneNumber);

    @PostMapping("/api/personalAccounts")
    public PersonalAccount saveNewPersonalAccount(@RequestBody PersonalAccount personalAccount);

    @PostMapping("/api/personalAccounts/makePayement")
    public Boolean makePayment(@RequestBody Bill bill);

    @PostMapping("/api/personalAccounts/verifyAccountExistence")
    public Boolean verifyAccountExistence(@RequestBody PersonalAccount personalAccount);


    // For company Account !!
    @GetMapping("/api/companiesAccounts/phoneNumber/{phoneNumber}")
    public Optional<CompanyAccount> getCompanyAccountByPhone(@PathVariable String phoneNumber);

    @GetMapping("/api/companiesAccounts/name/{name}")
    public Optional<CompanyAccount> getAccountByName(@PathVariable String name);


}
