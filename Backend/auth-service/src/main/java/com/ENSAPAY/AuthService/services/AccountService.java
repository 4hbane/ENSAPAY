package com.ENSAPAY.AuthService.services;

import com.ENSAPAY.AuthService.entities.Role;
import com.ENSAPAY.AuthService.entities.User;

public interface AccountService {
    public User saveUser(String userName , String password , String RoleName);
    public boolean updateUserPassword(String userName, String oldPassword, String newPassword, String confirmPassword);
    public User activateDeactivateUser(String userName);
    public Role save(Role role);
    public User loadUserByUserName(String userName);
    public void addRoleToUser(String userName, String roleName);
}
