package com.Dietary_Catering.Starter.Config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class UserAuthentication {


    public UserAuthentication() {
    }


    public  Object getUserName() {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getName();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
        } else {
            String username = principal.toString();
        }
        return principal;
    }
}
