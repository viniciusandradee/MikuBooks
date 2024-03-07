package com.api.MikuBooks.model;

import java.time.LocalDate;
import java.util.Random;

public record Usuario(Long id, String username, String email, String password, String telefone, LocalDate dataNascimento) {

    public Usuario(Long id, String username, String email, String password, String telefone, LocalDate dataNascimento){
        var key = (id != null) ? id : Math.abs( new Random().nextLong() );
        this.id = key;
        this.username = username;
        this.email = email;
        this.password = password;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

}