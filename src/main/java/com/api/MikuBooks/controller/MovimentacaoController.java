package com.api.MikuBooks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.MikuBooks.model.Movimentacao;
import com.api.MikuBooks.repository.MovimentacaoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping
public class MovimentacaoController {
    
    @Autowired
    MovimentacaoRepository repository;

    @PostMapping
    public Movimentacao create(@RequestBody @Valid Movimentacao movimentacao){
        return repository.save(movimentacao);
    }
}
