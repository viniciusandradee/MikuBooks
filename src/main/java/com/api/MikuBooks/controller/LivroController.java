package com.api.MikuBooks.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.MikuBooks.model.Livro;
import com.api.MikuBooks.repository.LivroRepository;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("livro")
@Slf4j
public class LivroController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping
    public List<Livro> index() {
        return livroRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Livro create(@RequestBody @Valid Livro livro) {
        log.info("cadastrando livro: {}", livro);
        return livroRepository.save(livro);
    }

    @GetMapping("{id}")
    public ResponseEntity<Livro> get(@PathVariable Long id) {
        log.info("Buscar por id: {}", id);

        return livroRepository
                    .findById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());

    }


    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) {
        log.info("apagando livro {}", id);

        verificarSeExisteLivro(id);
        livroRepository.deleteById(id);
    }


    @PutMapping("{id}")
    public Livro update(@PathVariable Long id, @RequestBody Livro livro){
        log.info("atualizando livro id {} para {}", id, livro);
        
        verificarSeExisteLivro(id);

        livro.setId(id);
        return livroRepository.save(livro);

    }

    
    private void verificarSeExisteLivro(Long id) {
        livroRepository
            .findById(id)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado" )
            );
    }


}