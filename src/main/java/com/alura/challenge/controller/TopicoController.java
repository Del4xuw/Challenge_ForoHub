package com.alura.challenge.controller;

import com.alura.challenge.api.response.TopicoRequest;
import com.alura.challenge.model.entity.Topico;
import com.alura.challenge.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kevin
 */
@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody TopicoRequest topicoRequest) {
        Topico topico = topicoService.registrarTopico(
                topicoRequest.getIdUsuario(),
                topicoRequest.getMensaje(),
                topicoRequest.getNombreCurso(),
                topicoRequest.getTitulo()
        );
        return new ResponseEntity<>(topico, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> actualizarTopico(@PathVariable Long id, @RequestBody TopicoRequest topicoRequest) {
        Topico topico = topicoService.actualizarTopico(id, topicoRequest.getMensaje(), topicoRequest.getTitulo());
        return new ResponseEntity<>(topico, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
        topicoService.eliminarTopico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listarTopicos() {
        List<Topico> topicos = topicoService.listarTopicos();
        return new ResponseEntity<>(topicos, HttpStatus.OK);
    }
}
