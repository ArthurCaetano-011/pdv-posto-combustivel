package com.br.pdvpostocombustivel.api.custo.dto;

import java.time.LocalDate;

//Para resposta
public record CustoResponse(
        double imposto,
        double frete,
        double seguro,
        double custoVariavel,
        double custoFixo,
        double margemLucro,
        LocalDate dataProcessamento
) {
}
