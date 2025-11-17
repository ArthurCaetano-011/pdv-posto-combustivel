package com.br.pdvpostocombustivel.enums;

public enum TipoCusto {
    CUSTOSFIXOS("Custos Fixos"),    // Renomeado de FIXO
    CUSTOSVARIAVEIS("Custos Variáveis"); // Renomeado de VARIAVEL

    private final String descricao;

    private TipoCusto(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}