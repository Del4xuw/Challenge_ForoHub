package com.alura.challenge.controller;

import com.alura.challenge.api.request.LoginRequest;
import com.alura.challenge.api.response.AuthResponse;
import com.alura.challenge.config.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

/**
 * @author Kevin
 */
@RestController
@RequestMapping("/auth/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping
    public AuthResponse authenticateUser(@RequestBody LoginRequest loginRequest) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getCorreoElectronico(),
                        loginRequest.getContrasena()
                )
        );

        String jwt = tokenProvider.generateToken(authentication);
        return new AuthResponse(jwt);
    }
}