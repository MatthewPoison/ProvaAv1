package com.matheus.relacionamentos.repository;

import com.matheus.relacionamentos.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}