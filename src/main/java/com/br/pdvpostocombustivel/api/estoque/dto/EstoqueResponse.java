package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.enums.TipoEstoque;

import java.math.BigDecimal;
import java.time.LocalDate;

//Para Resposta
public record EstoqueResponse(
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        LocalDate dataValidade,
        TipoEstoque tipoEstoque
) {
}
