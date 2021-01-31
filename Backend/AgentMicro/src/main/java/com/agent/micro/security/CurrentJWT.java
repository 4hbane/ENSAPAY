package com.agent.micro.security;

import javax.servlet.http.HttpServletRequest;

public interface CurrentJWT {

    public String getJWT(HttpServletRequest request);

}
