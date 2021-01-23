package com.ENSAPAY.Clientservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data @NoArgsConstructor
public class PersonalAccount extends Account {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    @Column(unique=true)
    private String cin;


    public PersonalAccount(String firstName, String lastName, String cin, String phoneNumber, String email, Double balance ) {
        super (phoneNumber, email, balance );
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
    }

}
