package com.alura.challenge.api.response;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Kevin
 */
@Data
public class TopicoRequest {
    private Long idUsuario;

    @NotBlank
    private String mensaje;

    @NotBlank
    private String nombreCurso;

    @NotBlank
    private String titulo;
}
