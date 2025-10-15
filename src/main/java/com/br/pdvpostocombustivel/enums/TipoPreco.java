package com.br.pdvpostocombustivel.enums;

public enum TipoPreco {
    VALORUNITARIO("Valor unitário"),
    VALORTOTAL("Valor Total");

    private final String descricao;

    private TipoPreco(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
