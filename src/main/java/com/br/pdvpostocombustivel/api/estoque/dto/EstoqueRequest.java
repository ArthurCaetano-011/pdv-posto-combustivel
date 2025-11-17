package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.enums.TipoEstoque;
import jakarta.validation.constraints.NotNull; // Adicionar importação
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

//Para Entrada
public record EstoqueRequest(
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dataValidade,
        TipoEstoque tipoEstoque
) {
}
