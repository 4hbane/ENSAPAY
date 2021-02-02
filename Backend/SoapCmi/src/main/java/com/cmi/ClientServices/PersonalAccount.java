package com.cmi.ClientServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonalAccount extends Account {
    private String firstName;
    private String lastName;
    private String cin;


    public PersonalAccount(String firstName, String lastName, String cin, String phoneNumber, String email, Double soldeInitial) {
            super(null, phoneNumber,email,soldeInitial,new Date (  ));
            this.firstName = firstName;
            this.lastName =lastName;
            this.cin = cin;
    }
}
