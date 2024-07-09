package com.alura.challenge.api.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Kevin
 */
@Data
public class LoginRequest {
    @Email
    @NotBlank
    private String correoElectronico;

    @NotBlank
    private String contrasena;
}
