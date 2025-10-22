package com.br.pdvpostocombustivel.api.contato.dto;

import com.br.pdvpostocombustivel.enums.TipoContato;
public record ContatoResponse(
        String telefone,
        String endereco,
        String email
) {
}
