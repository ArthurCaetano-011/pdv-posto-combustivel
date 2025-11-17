package com.br.pdvpostocombustivel.api.acesso.dto;

import com.br.pdvpostocombustivel.enums.TipoAcesso;

public record LoginResponse(String token, TipoAcesso tipoAcesso) {
}
