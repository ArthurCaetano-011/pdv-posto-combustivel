package com.br.pdvpostocombustivel.enums;

public enum TipoCusto {
    CUSTOSFIXOS("Custos Fixo"),
    CUSTOVARIAVEIS("Custos Variáveis"),
    CUSTOFRETE("Custo de Frete"),
    IMPOSTO("Custo de Imposto");

    private final String descricao;

    private TipoCusto(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
