package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.math.BigDecimal;

public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private BigDecimal valor;
    private Date dataAlteracao;
    private Date horaAlteracao;

    protected Preco() {}

    //construtor
    public Preco(BigDecimal valor, Date dataAlteracao, Date horaAlteracao) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
    }

    //getters
    public BigDecimal getValor(){
        return valor;
    }
    public Date getDataAlteracao(){
        return dataAlteracao;
    }
    public Date getHoraAlteracao(){
        return horaAlteracao;
    }
    public Long getId(){
        return id;
    }

    //setters
    public void setValor (BigDecimal valor){
        this.valor = valor;
    }
    public void setDataAlteracao (Date dataAlteracao){
        this.dataAlteracao = dataAlteracao;
    }
    public void setHoraAlteracao (Date horaAlteracao){
        this.horaAlteracao = horaAlteracao;
    }
    public void setId(Long id){
        this.id = id;
    }
}