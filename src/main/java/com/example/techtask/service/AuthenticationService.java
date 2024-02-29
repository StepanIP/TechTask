package com.example.techtask.service;


import com.example.techtask.dto.request.SignRequest;
import com.example.techtask.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignRequest request);

    JwtAuthenticationResponse signin(SignRequest request);
}