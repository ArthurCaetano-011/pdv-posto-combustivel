package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.enums.TipoContato;

//Para entrada
public record ContatoRequest(
        String telefone,
        String endereco,
        String email,
        TipoContato tipoContato
) {
}
