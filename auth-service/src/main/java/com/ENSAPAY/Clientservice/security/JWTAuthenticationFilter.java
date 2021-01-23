package com.ENSAPAY.Clientservice.security;

import com.ENSAPAY.Clientservice.repositories.UserRepository;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.ENSAPAY.Clientservice.entities.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private UserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, UserRepository userRepository){
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
           User user =new ObjectMapper().readValue(request.getInputStream(),User.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) authResult.getPrincipal();
        List<String> roles= new ArrayList<>();
        user.getAuthorities().forEach(a->{
            roles.add(a.getAuthority());
        });

        User userDetail = userRepository.findByUserName ( user.getUsername () );

        if (userDetail.isActivated ()) {  // vérifier d'abord si le user est activé avant de lui donner un JWT !
            String jwtToken = JWT.create ()
                    .withIssuer ( request.getRequestURI () )
                    .withSubject ( user.getUsername () )
                    .withArrayClaim ( "roles", roles.toArray ( new String[roles.size ()] ) )
                    .withExpiresAt ( new Date ( System.currentTimeMillis () + SecurityConstants.EXPIRATION_TIME ) )
                    .sign ( Algorithm.HMAC256 ( SecurityConstants.SECRET ) );
            response.addHeader ( SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + jwtToken );
        }
        else {
                response.setStatus ( 401 );
        }
    }

}
