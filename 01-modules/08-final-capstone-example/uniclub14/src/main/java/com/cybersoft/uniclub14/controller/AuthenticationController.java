package com.cybersoft.uniclub14.controller;

import com.cybersoft.uniclub14.request.SignInRequest;
import com.cybersoft.uniclub14.response.BaseResponse;
import com.cybersoft.uniclub14.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<BaseResponse> signIn(@RequestBody SignInRequest request) {
        String token = authenticationService.login(request);
        BaseResponse res = BaseResponse.success(token);

        return ResponseEntity.ok(res);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<String> signUp() {
        return ResponseEntity.ok("Welcome Sign Up");
    }
}
