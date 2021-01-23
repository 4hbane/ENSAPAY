package com.ENSAPAY.Clientservice.controllers;

import com.ENSAPAY.Clientservice.entities.UpdateUser;
import com.ENSAPAY.Clientservice.entities.User;
import com.ENSAPAY.Clientservice.repositories.RoleRepository;
import com.ENSAPAY.Clientservice.repositories.UserRepository;
import com.ENSAPAY.Clientservice.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api")
@AllArgsConstructor
public class AgentController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private AccountService accountService;
    private static final  String USER_ROlE = "AGENT";


    @GetMapping("/agents")
    public List<User> getUsers() {
        return userRepository.findAllByRole ( roleRepository.findByRoleName (USER_ROlE) );
    }
    @GetMapping("/agents/{id}")
    public User getUser(@PathVariable String id) {
        return userRepository.findByUserName ( id );
    }

    @GetMapping("/agents/setActivate/{id}") // deactivate or activate a user !
    public User activateDeactivateUser(@PathVariable( name = "id") Long id) {
        if (userRepository.existsByRoleAndId ( roleRepository.findByRoleName ( USER_ROlE ), id )) {
            User user = userRepository.findById ( id ).get ();
            return accountService.activateDeactivateUser ( user.getUserName () );
        }
        return null;
    }

    @PostMapping("/agents" )
    public User saveUser(@RequestBody User user){
        return accountService.saveUser ( user.getUserName (), user.getPassword (), USER_ROlE );
    }


    @PutMapping( "/agents/{id}" )
    public boolean updateUser(@PathVariable Long id, @RequestBody UpdateUser userWithNewPassword) {
        if (userRepository.existsByRoleAndId(roleRepository.findByRoleName(USER_ROlE), id)) {
            return accountService.updateUserPassword(userWithNewPassword.getUserName(), userWithNewPassword.getPassword(), userWithNewPassword.getNewPassword(), userWithNewPassword.getConfirmPassword());
        }
        return false;
    }

    @DeleteMapping("/agents/{id}")
    public void deleteUser(@PathVariable( name = "id") Long id){
        if(userRepository.existsByRoleAndId ( roleRepository.findByRoleName ( USER_ROlE ),id )){
            userRepository.deleteById ( id );
        }
    }

}
