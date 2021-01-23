package com.ENSAPAY.Clientservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class CompanyAccount extends Account {
    @NotNull
    @Column(unique = true)
    private String name;

    public CompanyAccount(String name, String phoneNumber,String email,  Double balance) {
        super (phoneNumber, email, balance );
        this.name = name;
    }
}
