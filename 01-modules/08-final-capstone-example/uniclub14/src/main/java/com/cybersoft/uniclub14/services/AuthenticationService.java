package com.cybersoft.uniclub14.services;

import com.cybersoft.uniclub14.request.SignInRequest;

public interface AuthenticationService {
    String login(SignInRequest request);
}
