package com.br.pdvpostocombustivel.enums;

public enum TipoCombustivel {
    GASOLINACOMUM("Gasolina Comum"),
    GASOLINAADITIVADA("Gasolina Aditivada"),
    ETANOLCOMUM("Etanol Comum"),
    ETANOLADITIVADA("Etanol Aditivada"),
    DIESEL("Diesel Comum"),
    BIODIESEL("Biodisel");

    private final String descricao;

    private TipoCombustivel(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
