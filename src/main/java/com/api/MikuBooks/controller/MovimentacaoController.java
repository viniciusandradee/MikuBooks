package com.api.MikuBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.api.MikuBooks.model.Movimentacao;
import com.api.MikuBooks.repository.MovimentacaoRepository;

@RestController
@RequestMapping
public class MovimentacaoController {
    
    @Autowired
    MovimentacaoRepository repository;

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao movimentacao){

        if (movimentacao.getDescricao() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return repository.save(movimentacao);
    }
}
