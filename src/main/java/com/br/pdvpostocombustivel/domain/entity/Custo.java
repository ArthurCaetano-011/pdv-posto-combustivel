package com.br.pdvpostocombustivel.domain.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Custo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private double imposto;
    private double frete;
    private double seguro;
    private double custoVariavel;
    private double custoFixo;
    private double margemLucro;

    protected Custo() {}

    //construtor
    public Custo(double imposto, double frete, double seguro, double custoVariavel, double custoFixo, double margemLucro){
        this.imposto = imposto;
        this.frete = frete;
        this.seguro = seguro;
        this.custoVariavel = custoVariavel;
        this.custoFixo = custoFixo;
        this.margemLucro = margemLucro;
    }

    //getters
    public double getImposto(){
        return imposto;
    }
    public double getFrete(){
        return frete;
    }
    public double getSeguro(){
        return seguro;
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
    public Long getId(){
        return id;
    }

    //setters
    public void setImposto (Double imposto){
        this.imposto = imposto;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }
    public void setSeguro(double seguro) {
        this.seguro = seguro;
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
    public void setId(Long id){
        this.id = id;
    }
}