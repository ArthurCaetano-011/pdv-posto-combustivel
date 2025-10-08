package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private String nome;
    private String referencia;
    private String fornecedor;
    private String marca;

    protected Produto() {}

    //construtor
    public  Produto(String nome, String referencia, String fornecedor, String marca){
        this.nome = nome;
        this.referencia = referencia;
        this.fornecedor = fornecedor;
        this.marca = marca;
    }

    //getters
    public String getNome(){
        return nome;
    }
    public String getReferencia(){
        return referencia;
    }
    public String getFornecedor(){
        return fornecedor;
    }
    public String getMarca(){
        return marca;
    }
    public Long getId(){
        return id;
    }

    //setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setReferencia(String referencia){
        this.referencia = referencia;
    }
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setId(Long id){
        this.id = id;
    }
}