package com.api.MikuBooks.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.api.MikuBooks.model.Livro;
import com.api.MikuBooks.model.Movimentacao;
import com.api.MikuBooks.repository.LivroRepository;
import com.api.MikuBooks.repository.MovimentacaoRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    MovimentacaoRepository movimentacaoRepository;

    @Override
    public void run(String... args) throws Exception {

        livroRepository.saveAll(
                List.of(
                        Livro.builder().id(1L).nome("Ação").icone("Action").build(),
                        Livro.builder().id(2L).nome("Jogos").icone("Games").build(),
                        Livro.builder().id(3L).nome("Tecnologia").icone("Technology").build(),
                        Livro.builder().id(4L).nome("Animais").icone("Animals").build(),
                        Livro.builder().id(5L).nome("Terror").icone("Horror").build(),
                        Livro.builder().id(6L).nome("Culinária").icone("Cooking").build(),
                        Livro.builder().id(7L).nome("Fazenda").icone("Farm").build()
                        ));

        movimentacaoRepository.saveAll(
                List.of(
                        Movimentacao.builder()
                                .id(1L)
                                .descricao("Aprendendo a cozinhar")
                                .data(LocalDate.now())
                                .valor(new BigDecimal(20))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(6L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(2L)
                                .descricao("Como cuidar de um cachorro")
                                .data(LocalDate.now().minusDays(1))
                                .valor(new BigDecimal(30))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(4L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(3L)
                                .descricao("Jason (O assassino)")
                                .data(LocalDate.now())
                                .valor(new BigDecimal(90))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(5L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(4L)
                                .descricao("Uncharted - Collection")
                                .data(LocalDate.now())
                                .valor(new BigDecimal(30))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(1L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(5L)
                                .descricao("Assassin's Creed - A coleção")
                                .data(LocalDate.now().minusDays(3))
                                .valor(new BigDecimal(200))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(2L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(6L)
                                .descricao("Five Night's at Freddy's")
                                .data(LocalDate.now().minusWeeks(1))
                                .valor(new BigDecimal(50))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(5L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(7L)
                                .descricao("Como treinar seu dragão")
                                .data(LocalDate.now().minusWeeks(4))
                                .valor(new BigDecimal(100))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(1L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(8L)
                                .descricao("A volta dos que não foram")
                                .data(LocalDate.now().minusMonths(2))
                                .valor(new BigDecimal(100))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(5L).get())
                                .build(),

                        Movimentacao.builder()
                                .id(9L)
                                .descricao("Temperando bistecas (2024)")
                                .valor(new BigDecimal(20))
                                .data(LocalDate.now())
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(6L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(10L)
                                .descricao("Uma noite misteriosa")
                                .valor(new BigDecimal(40))
                                .data(LocalDate.now().minusMonths(2))
                                .tipo("ENTRADA")
                                .livro(livroRepository.findById(5L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(11L)
                                .descricao("Cachorro World")
                                .valor(new BigDecimal(20))
                                .data(LocalDate.now().minusWeeks(8))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(2L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(12L)
                                .descricao("A morte instantânea")
                                .valor(new BigDecimal(30))
                                .data(LocalDate.now().minusWeeks(7))
                                .tipo("ENTRADA")
                                .livro(livroRepository.findById(5L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(13L)
                                .descricao("Club Penguin Dojo - Standart edition")
                                .valor(new BigDecimal(230))
                                .data(LocalDate.now().minusWeeks(10))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(2L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(14L)
                                .descricao("O começo")
                                .valor(new BigDecimal(90))
                                .data(LocalDate.now().minusWeeks(9))
                                .tipo("ENTRADA")
                                .livro(livroRepository.findById(1L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(15L)
                                .descricao("Um de vários")
                                .valor(new BigDecimal(200))
                                .data(LocalDate.now().minusWeeks(12))
                                .tipo("SAIDA")
                                .livro(livroRepository.findById(3L).get())
                                .build(),
                        Movimentacao.builder()
                                .id(16L)
                                .descricao("Como fazer c2 caseira")
                                .valor(new BigDecimal(200))
                                .data(LocalDate.now().minusWeeks(14))
                                .tipo("ENTRADA")
                                .livro(livroRepository.findById(3L).get())
                                .build())

        );

    }

}