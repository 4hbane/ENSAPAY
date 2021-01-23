package com.ENSAPAY.Clientservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Random;

@MappedSuperclass
@Data
@AllArgsConstructor @NoArgsConstructor
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String accountNumber;
    @NotNull
    private String phoneNumber;
    private String email;
    @NotNull
    private Double balance;
    @NotNull
    @Temporal ( TemporalType.DATE )
    private Date creationDate;



    public Account( String phoneNumber, String email, Double balance ) {
        this.id = null;
        this.accountNumber = generateAccountNumber();
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.balance = balance;
        this.creationDate = new Date ( );
    }


    private String generateAccountNumber(){
        Random random = new Random();
        int generatedNumber = random.nextInt(1000000);

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int stringLength = 4;
        Random r = new Random();

        String generatedString = r.ints(leftLimit, rightLimit + 1)
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString + generatedNumber;
    }

}
