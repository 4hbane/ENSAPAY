package com.ENSAPAY.Clientservice;

import com.ENSAPAY.Clientservice.entities.Role;
import com.ENSAPAY.Clientservice.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class AuthServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run( AuthServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
          accountService.save(new Role(null, "CLIENT"));
          accountService.save(new Role(null, "AGENT"));
          accountService.save(new Role(null, "ADMIN"));

          accountService.saveUser ( "0600001111", "ENSAPAY@ADMIN", "ADMIN" );

          accountService.saveUser ( "0600002222", "ENSAPAY@AGENT", "AGENT" );
          accountService.saveUser ( "0600003333", "ENSAPAY@AGENT", "AGENT" );

          accountService.saveUser ( "0608632756", "ENSAPAY@CLIENT", "CLIENT" );
          accountService.saveUser ( "0690287735", "ENSAPAY@CLIENT", "CLIENT" );

        };
   }
   @Bean
   BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
   }
}
