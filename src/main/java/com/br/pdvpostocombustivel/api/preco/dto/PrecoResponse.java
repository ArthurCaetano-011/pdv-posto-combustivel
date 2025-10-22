package com.br.pdvpostocombustivel.api.preco.dto;

import com.br.pdvpostocombustivel.enums.TipoPreco;

import java.math.BigDecimal;
import java.util.Date;

//Para resposta
public record PrecoResponse(
        BigDecimal valor,
        TipoPreco tipoPreco,
        Date dataAlteracao,
        Date horaAlteracao
) {
}
