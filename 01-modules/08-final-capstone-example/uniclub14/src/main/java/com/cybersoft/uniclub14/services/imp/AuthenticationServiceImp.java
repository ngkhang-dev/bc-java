package com.cybersoft.uniclub14.services.imp;

import com.cybersoft.uniclub14.entity.UserEntity;
import com.cybersoft.uniclub14.repository.UserRepository;
import com.cybersoft.uniclub14.request.SignInRequest;
import com.cybersoft.uniclub14.services.AuthenticationService;
import com.cybersoft.uniclub14.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImp implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Autowired
    public AuthenticationServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public String login(SignInRequest request) {
        String token = "";

        List<UserEntity> users = userRepository.findByEmail(request.email());
        if (!users.isEmpty()) {
            UserEntity userLogged = users.getFirst();

            if (passwordEncoder.matches(request.password(), userLogged.getPassword())) {
                token = jwtUtils.generateToken(userLogged.getEmail());
            } else {
                System.out.println("Login Failed");
            }

        } else {
            System.out.println("Login Failed");
        }

        return token;
    }
}
