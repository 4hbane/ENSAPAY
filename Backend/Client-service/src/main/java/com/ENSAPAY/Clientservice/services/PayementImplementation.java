package com.ENSAPAY.Clientservice.services;

import com.ENSAPAY.Clientservice.entities.CompanyAccount;
import com.ENSAPAY.Clientservice.entities.PersonalAccount;
import com.ENSAPAY.Clientservice.repositories.CompanyAccountRepository;
import com.ENSAPAY.Clientservice.repositories.PersonalAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PayementImplementation implements Payement {
    @Autowired
    private PersonalAccountRepository personalAccountRepository;
    @Autowired
    private CompanyAccountRepository companyAccountRepository;

    @Override
    public Boolean makePayment(Bill bill){
        Optional<PersonalAccount> customerAccount = personalAccountRepository.findByAccountNumber ( bill.getCustomerAccount () );
        Optional<CompanyAccount> ownerAccount = companyAccountRepository.findByAccountNumber ( bill.getCompanyAccount () );

        if (!customerAccount.isPresent ()) {
            return  false;
        }
        if ((customerAccount.get ().getBalance () - bill.getBalance ()) < 0 ) {
            return false;
        }

        customerAccount.get ().setBalance ( customerAccount.get ().getBalance () - bill.getBalance () );
        personalAccountRepository.changeBalance ( customerAccount.get ().getBalance (),customerAccount.get ().getAccountNumber () );

        if (ownerAccount.isPresent ()) {
            ownerAccount.get ().setBalance ( ownerAccount.get ().getBalance () + bill.getBalance () );
            companyAccountRepository.changeBalance ( customerAccount.get ().getBalance (),customerAccount.get ().getAccountNumber () );
        }

        return true;
    }
}
