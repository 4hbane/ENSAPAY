package com.ENSAPAY.AuthService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor @NoArgsConstructor
public class UpdateUser {
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private String newPassword;
    @NonNull
    private String confirmPassword;
}
