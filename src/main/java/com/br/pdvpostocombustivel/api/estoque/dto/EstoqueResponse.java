package com.br.pdvpostocombustivel.api.estoque.dto;

import java.math.BigDecimal;
import java.util.Date;

//Para Entrada
public record EstoqueResponse(
        BigDecimal quantidade,
        String localTanque,
        String localEndereco,
        String loteFabricacao,
        Date dataValidade
) {
}
