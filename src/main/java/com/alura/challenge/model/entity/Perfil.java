package com.alura.challenge.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * @author Kevin
 */
@Data
@Entity
@Table(name = "perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "perfiles")
    private Set<Usuario> usuarios;
}
