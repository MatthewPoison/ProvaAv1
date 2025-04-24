package com.matheus.relacionamentos.controller;

import com.matheus.relacionamentos.exception.AutorNaoEncontradoException;
import com.matheus.relacionamentos.model.Autor;
import com.matheus.relacionamentos.model.Livro;
import com.matheus.relacionamentos.repository.AutorRepository;
import com.matheus.relacionamentos.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado."));
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        Autor autor = autorRepository.findById(livro.getAutor().getId())
                .orElseThrow(() -> new AutorNaoEncontradoException("Autor com ID " + livro.getAutor().getId() + " não encontrado."));
        livro.setAutor(autor);
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        return livroRepository.findById(id).map(livro -> {
            livro.setTitulo(livroAtualizado.getTitulo());
            livro.setAnoPublicacao(livroAtualizado.getAnoPublicacao());
            livro.setIsbn(livroAtualizado.getIsbn());
            livro.setEditora(livroAtualizado.getEditora());
            livro.setNumeroPaginas(livroAtualizado.getNumeroPaginas());
            livro.setGenero(livroAtualizado.getGenero());
            if (livroAtualizado.getAutor() != null) {
                Autor autor = autorRepository.findById(livroAtualizado.getAutor().getId())
                        .orElseThrow(() -> new AutorNaoEncontradoException("Autor com ID " + livroAtualizado.getAutor().getId() + " não encontrado."));
                livro.setAutor(autor);
            }
            return livroRepository.save(livro);
        }).orElseThrow(() -> new RuntimeException("Livro com ID " + id + " não encontrado."));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!livroRepository.existsById(id)) {
            throw new RuntimeException("Livro com ID " + id + " não encontrado.");
        }
        livroRepository.deleteById(id);
    }
}