package com.br.pdvpostocombustivel.api.acesso.dto;

import com.br.pdvpostocombustivel.enums.TipoAcesso;

//Para resposta
public record AcessoResponse(
        String usuario,
        String senha
) { }
