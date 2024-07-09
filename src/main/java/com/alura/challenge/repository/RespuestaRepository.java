package com.alura.challenge.repository;

import com.alura.challenge.model.entity.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
}