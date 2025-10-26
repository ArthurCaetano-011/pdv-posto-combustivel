package com.br.pdvpostocombustivel.domain.entity;


import com.br.pdvpostocombustivel.enums.TipoCusto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "custos")

public class Custo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    @Column(length = 8,nullable = false)
    private double imposto;

    @Column(length = 8, nullable = false)
    private double frete;

    @Column(length = 8,nullable = false)
    private double custoVariavel;

    @Column(length = 10,nullable = false)
    private double custoFixo;

    @Column(length = 10,nullable = false)
    private double margemLucro;

    @Column(length = 10, nullable = false)
    private LocalDate dataProcessamento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_custo", length = 30, nullable = false)
    private TipoCusto tipoCusto;

    protected Custo() {}

    //construtor
    public Custo(double imposto, double frete, double custoVariavel, double custoFixo, double margemLucro, LocalDate dataProcessamento, TipoCusto tipoCusto){
        this.imposto = imposto;
        this.frete = frete;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.margemLucro = margemLucro;
        this.dataProcessamento = dataProcessamento;
        this.tipoCusto = tipoCusto;
    }

    //getters
    public double getImposto(){
        return imposto;
    }
    public double getFrete(){
        return frete;
    }
    public double getCustoVariavel(){
        return custoVariavel;
    }
    public double getCustoFixo(){
        return custoFixo;
    }
    public double getMargemLucro(){
        return margemLucro;
    }
    public LocalDate getDataProcessamento(){
        return dataProcessamento;
    }
    public Long getId(){
        return id;
    }
    public TipoCusto getTipoCusto(){
        return tipoCusto;
    }

    //setters
    public void setImposto (double imposto){
        this.imposto = imposto;
    }
    public void setFrete(double frete) {
        this.frete = frete;
    }
    public void setCustoVariavel(double custoVariavel) {
        this.custoVariavel = custoVariavel;
    }
    public void setCustoFixo(double custoFixo) {
        this.custoFixo = custoFixo;
    }
    public void setMargemLucro(double margemLucro) {
        this.margemLucro = margemLucro;
    }
    public void setDataProcessamento(LocalDate dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setTipoCusto (TipoCusto tipoCusto){
        this.tipoCusto = tipoCusto;
    }
}