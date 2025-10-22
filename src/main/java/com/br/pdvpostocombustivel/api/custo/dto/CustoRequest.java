package com.br.pdvpostocombustivel.api.custo.dto;

import com.br.pdvpostocombustivel.enums.TipoCusto;

//Para entrada
public record CustoRequest(
        double imposto,
        double frete,
        double seguro,
        double custoVariavel,
        double custoFixo,
        double margemLucro,
        TipoCusto tipoCusto
) {
}
