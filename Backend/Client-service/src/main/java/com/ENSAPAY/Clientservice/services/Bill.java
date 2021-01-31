package com.ENSAPAY.Clientservice.services;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Bill {
    private String customerAccount;
    private String companyAccount;
    private Double balance;
}
