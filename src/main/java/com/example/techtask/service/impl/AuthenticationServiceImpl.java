package com.example.techtask.service.impl;

import com.example.techtask.dto.request.SignRequest;
import com.example.techtask.dto.response.JwtAuthenticationResponse;
import com.example.techtask.model.User;
import com.example.techtask.repository.UserRepository;
import com.example.techtask.service.AuthenticationService;
import com.example.techtask.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignRequest request) {
        User account = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
        userRepository.save(account);
        var jwt = jwtService.generateToken(account);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail());
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}