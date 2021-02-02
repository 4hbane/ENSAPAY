package com.ENSAPAY.Clientservice.repositories;

import com.ENSAPAY.Clientservice.entities.PersonalAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@RepositoryRestResource(exported = false)
public interface PersonalAccountRepository extends JpaRepository<PersonalAccount, Long> {

    Optional<PersonalAccount> findByAccountNumber(String accountNumber);
    Optional<PersonalAccount> findByPhoneNumber(String phoneNumber);
    Boolean existsByAccountNumber( String AccountNumber);
    Boolean existsByFirstNameAndLastNameAndCin( String firstName, String lastName, String cin);

    @Transactional
    @Modifying
    @Query("UPDATE PersonalAccount p  set p.balance=:balance where p.accountNumber=:accountNumber")
    public void changeBalance(@Param("balance") Double balance, @Param("accountNumber") String accountNumber);



}
