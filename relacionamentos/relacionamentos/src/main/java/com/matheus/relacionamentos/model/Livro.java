package com.matheus.relacionamentos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private int anoPublicacao;

    private String isbn;

    private String editora;

    private int numeroPaginas;

    private String genero;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    @JsonBackReference
    private Autor autor;
}