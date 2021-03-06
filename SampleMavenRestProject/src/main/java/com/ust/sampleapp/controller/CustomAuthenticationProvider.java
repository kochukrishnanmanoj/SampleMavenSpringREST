package com.ust.sampleapp.controller;

import java.util.ArrayList;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        System.err.println("doing check in from github"+name);
        System.err.println("name"+name);
        System.out.println("password" + password);
            // use the credentials
            // and authenticate against the third-party system
        if(name.equals("temp") && password.equals("temp")) {
        	return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
        } else {
        	return null;
        }
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
          UsernamePasswordAuthenticationToken.class);
    }

}
