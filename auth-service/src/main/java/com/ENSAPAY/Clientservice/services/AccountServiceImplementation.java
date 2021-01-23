package com.ENSAPAY.Clientservice.services;

import com.ENSAPAY.Clientservice.entities.Role;
import com.ENSAPAY.Clientservice.entities.User;
import com.ENSAPAY.Clientservice.repositories.RoleRepository;
import com.ENSAPAY.Clientservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImplementation implements AccountService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

   @Override
    public User saveUser(String userName, String password, String RoleName) {
        if(userRepository.findByUserName(userName) != null) throw new RuntimeException(("User already exists"));
        User userAdded = userRepository.save(new User(userName, bCryptPasswordEncoder.encode ( password ), true));
        addRoleToUser(userName,RoleName);
        return userAdded;
    }

    @Override
    public boolean updateUserPassword(String userName, String oldPassword, String newPassword, String confirmPassword) {
        User user = userRepository.findByUserName(userName);
        if( user == null) throw new RuntimeException(("User doesn't exists !"));
        if ( BCrypt.checkpw ( oldPassword, user.getPassword () ) && newPassword.equals ( confirmPassword ) ) {
            user.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User activateDeactivateUser(String userName) {
            User user = userRepository.findByUserName(userName);
            if(user == null) throw new RuntimeException(("User doesn't exists !"));
            if ( user.isActivated () ){
                user.setActivated ( false );
            }else {
                user.setActivated ( true );
            }
           return userRepository.save ( user );
    }


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User loadUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = userRepository.findByUserName(userName);
        Role role = roleRepository.findByRoleName(roleName);
        user.setRole ( role );
    }

}
