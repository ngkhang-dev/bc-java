package com.cybersoft.uniclub14.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn () {
        return ResponseEntity.ok("Welcome Sign In");
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp () {
        return ResponseEntity.ok("Welcome Sign Up");
    }
}
