package com.br.pdvpostocombustivel.api.custo.dto;

import com.br.pdvpostocombustivel.enums.TipoCusto;

import java.time.LocalDate;

//Para entrada
public record CustoRequest(
        Double imposto,
        Double frete,
        Double seguro,
        Double custoVariavel,
        Double custoFixo,
        Double margemLucro,
        LocalDate dataProcessamento,
        TipoCusto tipoCusto
) {
}
