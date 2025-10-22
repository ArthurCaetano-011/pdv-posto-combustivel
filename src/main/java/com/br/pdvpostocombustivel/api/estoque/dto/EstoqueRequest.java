package com.br.pdvpostocombustivel.api.estoque.dto;

import com.br.pdvpostocombustivel.enums.TipoEstoque;

import java.math.BigDecimal;

//Para Entrada
public record EstoqueRequest(
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        String dataValidade,
        TipoEstoque tipoEstoque
) {
}
