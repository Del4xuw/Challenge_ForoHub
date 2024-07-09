package com.alura.challenge.service;

import com.alura.challenge.model.entity.Curso;
import com.alura.challenge.model.entity.Topico;
import com.alura.challenge.model.entity.Usuario;
import com.alura.challenge.repository.CursoRepository;
import com.alura.challenge.repository.TopicoRepository;
import com.alura.challenge.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Kevin
 */
@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Topico registrarTopico(Long idUsuario, String mensaje, String nombreCurso, String titulo) {
        Usuario autor = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Curso curso = cursoRepository.findByNombre(nombreCurso)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(titulo);
        topico.setMensaje(mensaje);
        topico.setFechaCreacion(LocalDateTime.now());
        topico.setStatus("Abierto");
        topico.setAutor(autor);
        topico.setCurso(curso);

        return topicoRepository.save(topico);
    }

    public Topico actualizarTopico(Long id, String mensaje, String titulo) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        topico.setMensaje(mensaje);
        topico.setTitulo(titulo);

        return topicoRepository.save(topico);
    }

    public void eliminarTopico(Long id) {
        topicoRepository.deleteById(id);
    }

    public List<Topico> listarTopicos() {
        return topicoRepository.findAll();
    }
}
