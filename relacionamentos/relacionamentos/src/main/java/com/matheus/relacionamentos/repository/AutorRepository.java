
package com.matheus.relacionamentos.repository;

import com.matheus.relacionamentos.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
