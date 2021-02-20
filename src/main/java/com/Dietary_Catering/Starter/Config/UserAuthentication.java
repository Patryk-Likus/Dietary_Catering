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
       /* SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String userName = null;
        if (authentication != null) {

            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            userName = userDetails.getUsername();

        }*/
       /* Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> username = loggedInUser.getAuthorities();
        for (GrantedAuthority g : username) {
            System.out.println(g);
        }*/
        Object principal = SecurityContextHolder.getContext().getAuthentication().getName();

        if (principal instanceof UserDetails) {
            String username = ((UserDetails)principal).getUsername();
        } else {
            String username = principal.toString();
        }
        return principal;
    }
}
