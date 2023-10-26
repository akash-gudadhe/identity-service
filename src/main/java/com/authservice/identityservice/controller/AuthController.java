package com.authservice.identityservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.authservice.identityservice.entity.UserCredential;
import com.authservice.identityservice.service.AuthService;
import com.authservice.identityservice.service.JwtService;

import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/auth/")
public class AuthController {
    @Autowired
    private AuthService service;

    @Autowired
    private JwtService jwtService;

    

    @PostMapping("register")
    public String addNewUser(@RequestBody UserCredential user){
        return service.saveUser(user);
    }

    @GetMapping("hello")
    public String welcome(){
       

        return "validation is incomplete";
    }


    @PostMapping("token")
    public String generateToken(@RequestBody UserCredential user){
        return jwtService.generateToken(user.getName());
    }

    @GetMapping("validate")
    public boolean validateToken(@RequestHeader Map<String, String> headers){
        String bearerToken = headers.get("authorization");
        // System.out.println(bearerToken.substring(7));

        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
            
            return jwtService.validateToken(bearerToken.substring(7));
        }
        
        return false;
    }
}
