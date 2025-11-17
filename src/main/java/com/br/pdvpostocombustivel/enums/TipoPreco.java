package com.br.pdvpostocombustivel.enums;

public enum TipoPreco {
    UNITARIO("Valor unitário"),
    TOTAL("Valor Total");

    private final String descricao;

    private TipoPreco(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
