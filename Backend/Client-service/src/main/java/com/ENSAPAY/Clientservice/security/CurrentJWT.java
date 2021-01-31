package com.ENSAPAY.Clientservice.security;

import javax.servlet.http.HttpServletRequest;

public interface CurrentJWT {

    public String getJWT(HttpServletRequest request);

}
