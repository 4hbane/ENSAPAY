package com.ENSAPAY.Clientservice.security;

import com.ENSAPAY.Clientservice.entities.User;
import com.ENSAPAY.Clientservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service //cette classe va etre instanciée au démarrage
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //pour savoir si un user existe on appelle cette méthode
        User user = accountService.loadUserByUserName(userName);
        if(user==null) throw new UsernameNotFoundException("Invalid username");
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole ().getRoleName()));

        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), authorities);
    }
}
