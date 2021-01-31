package com.ENSAPAY.AuthService.controllers;

import com.ENSAPAY.AuthService.entities.UpdateUser;
import com.ENSAPAY.AuthService.entities.User;
import com.ENSAPAY.AuthService.repositories.RoleRepository;
import com.ENSAPAY.AuthService.repositories.UserRepository;
import com.ENSAPAY.AuthService.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@AllArgsConstructor
public class CustomerController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AccountService accountService;
    private static final  String USER_ROlE = "CLIENT";


    @GetMapping("/clients")
    public List<User> getUser() {
        return userRepository.findAllByRole ( roleRepository.findByRoleName (USER_ROlE) );
    }
    @GetMapping("/clients/{id}")
    public User getUser(@PathVariable String id) {
        return userRepository.findByUserName ( id );
    }

    @GetMapping("/clients/setActivate/{id}") // deactivate or activate a user !
    public User activateDeactivateUser(@PathVariable( name = "id") Long id) {
       if (userRepository.existsByRoleAndId ( roleRepository.findByRoleName ( USER_ROlE ), id )) {
            User user = userRepository.findById ( id ).get ();
            return accountService.activateDeactivateUser ( user.getUserName () );
       }
        return null;
    }

    @PostMapping("/clients" )
    public User saveUser(@RequestBody User user){
        return accountService.saveUser ( user.getUserName (), user.getPassword (), USER_ROlE );
    }


    @PutMapping( "/clients/{id}" )
    public boolean updateUser(@PathVariable Long id, @RequestBody UpdateUser userWithNewPassword) {
        if (userRepository.existsByRoleAndId(roleRepository.findByRoleName(USER_ROlE), id)) {
            User user = userRepository.findById(id).get();
            return accountService.updateUserPassword(userWithNewPassword.getUserName(), userWithNewPassword.getPassword(), userWithNewPassword.getNewPassword(), userWithNewPassword.getConfirmPassword());
        }
        return false;
    }

    @DeleteMapping("/clients/{userName}")
    public void deleteUserByUserName(@PathVariable String userName){
        if(userRepository.existsByRoleAndUserName ( roleRepository.findByRoleName ( USER_ROlE ),userName )){
            User userToDelete = userRepository.findByUserName ( userName );
            userToDelete.setRole ( null );
            userRepository.save ( userToDelete );
            userRepository.deleteById ( userToDelete.getId () );
        }
    }
}
