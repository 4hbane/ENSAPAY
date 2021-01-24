package com.ENSAPAY.Clientservice.ExternalServices;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data @AllArgsConstructor @NoArgsConstructor
public class User {
    private String userName; //phoneNumber
    private String password;
}
