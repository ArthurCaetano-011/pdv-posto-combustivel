package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoCombustivel;
import com.br.pdvpostocombustivel.enums.TipoEstoque;
import com.br.pdvpostocombustivel.enums.TipoLubrificante;
import com.br.pdvpostocombustivel.enums.TipoProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    @Column(length = 15,nullable = false)
    private String nome;

    @Column(length = 15,nullable = false)
    private String referencia;

    @Column(length = 20, nullable = false)
    private String fornecedor;

    @Column(length = 15,nullable = false)
    private String marca;

    @Column(length = 30, nullable = false)
    private String categoria;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_estoque",length = 30,nullable = false)
    private TipoProduto tipoProduto;


    protected Produto() {}

    //construtor
    public  Produto(String nome, String referencia, String fornecedor, String marca, String categoria, TipoProduto tipoProduto){
        this.nome = nome;
        this.referencia = referencia;
        this.fornecedor = fornecedor;
        this.marca = marca;
        this.categoria = categoria;
        this.tipoProduto = tipoProduto;
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
    public String getCategoria(){
        return  categoria;
    }
    public TipoProduto getTipoProduto(){
        return tipoProduto;
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
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setTipoProduto(TipoProduto tipoProduto){
        this.tipoProduto = tipoProduto;
    }
    public void setId(Long id){
        this.id = id;
    }
}