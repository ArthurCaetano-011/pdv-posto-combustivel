package com.br.pdvpostocombustivel.api.custo.dto;

import com.br.pdvpostocombustivel.enums.TipoCusto;

import java.time.LocalDate;

//Para entrada
public record CustoRequest(
        double imposto,
        double frete,
        double seguro,
        double custoVariavel,
        double custoFixo,
        double margemLucro,
        LocalDate dataProcessamento,
        TipoCusto tipoCusto
) {
}
