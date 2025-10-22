package com.br.pdvpostocombustivel.api.estoque.dto;

import java.math.BigDecimal;

//Para Entrada
public record EstoqueResponse(
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        String dataValidade
) {
}
