package com.alura.challenge.controller;

import com.alura.challenge.api.request.UsuarioRequest;
import com.alura.challenge.model.entity.Usuario;
import com.alura.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public Usuario crearUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioRequest.getNombre());
        usuario.setCorreoElectronico(usuarioRequest.getCorreoElectronico());
        usuario.setContrasena(passwordEncoder.encode(usuarioRequest.getContrasena()));

        return usuarioRepository.save(usuario);
    }
}
