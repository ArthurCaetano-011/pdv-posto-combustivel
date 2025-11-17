package com.br.pdvpostocombustivel.api.preco.dto;

import com.br.pdvpostocombustivel.enums.TipoPreco;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


//Para resposta
public record PrecoResponse(
        BigDecimal valor,
        LocalDate dataAlteracao,
        LocalDate horaAlteracao,
        TipoPreco tipoPreco

) {
}
