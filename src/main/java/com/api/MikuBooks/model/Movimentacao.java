package com.api.MikuBooks.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.api.MikuBooks.validation.TipoMovimentacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
@Entity
public class Movimentacao {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{movimentacao.descricao.notblank}")
    @Size(min = 3, message = "{movimentacao.descricao.size}")
    private String descricao;

    @Positive(message = "{movimentacao.valor.positive}")
    private BigDecimal valor;

    @PastOrPresent
    private LocalDate data;
    
    @TipoMovimentacao(message = "{movimentacao.tipo.tipomovimentacao}")
    private String tipo; // ENTRADA | SAIDA
}
