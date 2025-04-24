
package com.matheus.relacionamentos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String biografia;

    private String nacionalidade;

    private LocalDate dataNascimento;

    @CreationTimestamp
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Livro> livros;
}
