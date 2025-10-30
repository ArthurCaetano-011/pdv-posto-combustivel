package com.br.pdvpostocombustivel.api.custo.dto;

import com.br.pdvpostocombustivel.enums.TipoCusto;

import java.time.LocalDate;

//Para resposta
public record CustoResponse(
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
