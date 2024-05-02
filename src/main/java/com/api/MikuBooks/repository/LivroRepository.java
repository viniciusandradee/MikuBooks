package com.api.MikuBooks.repository;

import com.api.MikuBooks.model.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
    
}
