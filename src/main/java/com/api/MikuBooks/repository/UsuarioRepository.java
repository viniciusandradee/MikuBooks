package com.api.MikuBooks.repository;

import com.api.MikuBooks.model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    
}
