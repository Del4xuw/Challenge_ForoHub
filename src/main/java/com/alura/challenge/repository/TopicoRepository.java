package com.alura.challenge.repository;

import com.alura.challenge.model.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}