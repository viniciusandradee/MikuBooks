package com.api.MikuBooks.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.api.MikuBooks.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

    Page<Movimentacao> findByLivroNomeIgnoreCase(String livro, Pageable pageable);

    //JPQL - Java Persistence Query Language
    @Query("SELECT m FROM Movimentacao m WHERE MONTH(m.data) = :mes")
    Page<Movimentacao> findByMes(@Param("mes") Integer mes, Pageable pageable);

    @Query("SELECT m FROM Movimentacao m WHERE m.livro.nome = :livro AND MONTH(m.data) = :mes")
    Page<Movimentacao> findByLivroNomeAndMes(@Param("livro") String livro, @Param("mes") Integer mes, Pageable pageable);

    Movimentacao findFirstByOrderByValor();

    // @Query("SELECT m FROM Movimentacao m ORDER BY m.id LIMIT ?2 OFFSET ?1")
    // List<Movimentacao> findAllPageable(int offset, int size);

    // @Query("SELECT m FROM Movimentacao m ORDER BY m.valor DESC Limit 1")
    // Movimentacao getMaior();
    // @Query("SELECT m FROM Movimentacao m ORDER BY m.valor Limit 1")
    // Movimentacao getMenor();
    // @Query("SELECT m FROM Movimentacao m ORDER BY m.data DESC Limit 1")
    // Movimentacao getUltima();
    
}