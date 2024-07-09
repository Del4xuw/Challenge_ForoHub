package com.alura.challenge.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * @author Kevin
 */
@Entity
@Table(name = "curso")
@Data
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String categoria;

    @OneToMany(mappedBy = "curso")
    private List<Topico> topicos;
}
