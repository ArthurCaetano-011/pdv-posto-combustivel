package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoEstoque;
import com.br.pdvpostocombustivel.enums.TipoPreco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "precos")
public class Preco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    @Column(length = 8,nullable = false)
    private BigDecimal valor;

    @Column(length = 10,nullable = false)
    private Date dataAlteracao;

    @Column(length = 10, nullable = false)
    private Date horaAlteracao;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_preco",length = 30,nullable = false)
    private TipoPreco tipoPreco;


    protected Preco() {}

    //construtor
    public Preco(BigDecimal valor, Date dataAlteracao, Date horaAlteracao,TipoPreco tipoPreco) {
        this.valor = valor;
        this.dataAlteracao = dataAlteracao;
        this.horaAlteracao = horaAlteracao;
        this.tipoPreco = tipoPreco;
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
    public TipoPreco getTipoPreco(){
        return tipoPreco;
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
    public void setTipoPreco(TipoPreco tipoPreco){
        this.tipoPreco = tipoPreco;
    }
}