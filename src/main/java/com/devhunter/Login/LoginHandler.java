package com.devhunter.Login;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoginHandler {
    
    public String tryLogin() {
        return "Hello from Quarkus REST";
    }
    
}