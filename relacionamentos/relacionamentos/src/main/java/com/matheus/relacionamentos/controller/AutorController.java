package com.matheus.relacionamentos.controller;

import com.matheus.relacionamentos.model.Autor;
import com.matheus.relacionamentos.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;

    @GetMapping
    public List<Autor> listarTodos() {
        return autorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Autor buscarPorId(@PathVariable Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor com ID " + id + " não encontrado."));
    }

    @PostMapping
    public Autor criar(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

    @PutMapping("/{id}")
    public Autor atualizar(@PathVariable Long id, @RequestBody Autor autorAtualizado) {
        return autorRepository.findById(id).map(autor -> {
            autor.setNome(autorAtualizado.getNome());
            autor.setBiografia(autorAtualizado.getBiografia());
            autor.setNacionalidade(autorAtualizado.getNacionalidade());
            autor.setDataNascimento(autorAtualizado.getDataNascimento());
            return autorRepository.save(autor);
        }).orElseThrow(() -> new RuntimeException("Autor com ID " + id + " não encontrado."));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!autorRepository.existsById(id)) {
            throw new RuntimeException("Autor com ID " + id + " não encontrado.");
        }
        autorRepository.deleteById(id);
    }
}