package com.cmi.ClientServices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String accountNumber;
    private String phoneNumber;
    private String email;
    private Double balance;
    private Date creationDate;
}
