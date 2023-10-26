package com.authservice.identityservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authservice.identityservice.entity.UserCredential;
import com.authservice.identityservice.repository.UserCredentialRepository;

@Service
public class AuthService {
    @Autowired
    private UserCredentialRepository userCredRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserCredential user){
        passwordEncoder.encode(user.getPassword());
        userCredRepo.save(user);
        return "user added to the system";
    }
}
