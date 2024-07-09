package com.alura.challenge.api.response;

import lombok.Data;

/**
 * @author Kevin
 */
@Data
public class AuthResponse {
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}