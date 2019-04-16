package com.skmns.oauth2.users;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/abc")
    public String abc() {
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        System.out.println(auth.getCredentials());
        System.out.println(auth.getDetails());
        System.out.println(auth.getName());
    // System.out.println(((UserDetails)auth.getPrincipal()).getAccount());
        System.out.println(auth.getAuthorities());
        
        return "HELLO ["+auth.getName()+"]";
    }
}
