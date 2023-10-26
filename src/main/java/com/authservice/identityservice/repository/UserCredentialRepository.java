package com.authservice.identityservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authservice.identityservice.entity.UserCredential;
import java.util.List;
import java.util.Optional;


public interface UserCredentialRepository extends JpaRepository<UserCredential, Integer> {
    Optional<UserCredential> findByName(String name);
}
