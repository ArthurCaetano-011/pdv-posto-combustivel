package com.br.pdvpostocombustivel.enums;

public enum TipoLubrificante {
    SINTETICO("Lubrificante Sintético"),
    SEMISSINTETICO("Lubrificante Semissintético"),
    MINERAIS("Lubrificante Mineral");

    private final String descricao;

    private TipoLubrificante(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
