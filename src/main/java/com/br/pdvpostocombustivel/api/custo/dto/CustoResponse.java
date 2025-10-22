package com.br.pdvpostocombustivel.api.custo.dto;

//Para resposta
public record CustoResponse(
        double imposto,
        double frete,
        double seguro,
        double custoVariavel,
        double custoFixo,
        double margemLucro
) {
}
