package com.ENSAPAY.Clientservice.security;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CurrentJWTImplementation implements CurrentJWT {
    @Override
    public String getJWT(HttpServletRequest request) {
        String jwtToken = request.getHeader( SecurityConstants.HEADER_STRING);

        if (jwtToken == null || !jwtToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            return null;
        }

        return jwtToken;
    }

}
