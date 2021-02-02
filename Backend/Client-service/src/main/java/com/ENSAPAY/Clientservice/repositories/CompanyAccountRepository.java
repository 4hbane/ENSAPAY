package com.ENSAPAY.Clientservice.repositories;


import com.ENSAPAY.Clientservice.entities.CompanyAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RepositoryRestResource(exported = false)
public interface CompanyAccountRepository extends JpaRepository<CompanyAccount, Long> {

    Optional<CompanyAccount> findByAccountNumber(String accountNumber);
    Optional<CompanyAccount> findByPhoneNumber(String phoneNumber);
    Optional<CompanyAccount> findByName(String name);

    Boolean existsByAccountNumber( String AccountNumber);

    @Transactional
    @Modifying
    @Query("UPDATE CompanyAccount c  set c.balance=:balance where c.accountNumber=:accountNumber")
    public void changeBalance(@Param("balance") double balance, @Param("accountNumber") String accountNumber);


}
