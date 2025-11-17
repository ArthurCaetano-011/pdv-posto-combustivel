package com.br.pdvpostocombustivel.domain.entity;


import com.br.pdvpostocombustivel.enums.TipoEstoque;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "estoques")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    @Column(length = 10,nullable = false)
    private BigDecimal quantidade;

    @Column(length = 50, nullable = false)
    private String localTanque;

    @Column(length = 100,nullable = false)
    private String localEndereco;

    @Column(length = 10,nullable = false)
    private String loteFabricacao;

    @Column(length = 10,nullable = false)
    private LocalDate dataValidade;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_estoque",length = 30,nullable = false)
    private TipoEstoque tipoEstoque;

    protected Estoque() {}

    //construtor
    public Estoque(BigDecimal quantidade, String localTanque, String localEndereco, String loteFabricacao, LocalDate dataValidade, TipoEstoque tipoEstoque){
        this.quantidade = quantidade;
        this.localTanque = localTanque;
        this.localEndereco = localEndereco;
        this.loteFabricacao = loteFabricacao;
        this.dataValidade = dataValidade;
        this.tipoEstoque = tipoEstoque;
    }

    //getters
    public BigDecimal getQuantidade(){
        return quantidade;
    }
    public String getLocalTanque(){
        return localTanque;
    }
    public String getLocalEndereco(){
        return localEndereco;
    }
    public String getLoteFabricacao(){
        return loteFabricacao;
    }
    public LocalDate getDataValidade(){
        return dataValidade;
    }
    public TipoEstoque getTipoEstoque(){
        return tipoEstoque;
    }
    public Long getId(){
        return id;
    }

    //setters
    public void setQuantidade(BigDecimal quantidade){
        this.quantidade = quantidade;
    }
    public void setLocalTanque(String localTanque){
        this.localTanque = localTanque;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }
    public void setLoteFabricacao(String loteFabricacao) {
        this.loteFabricacao = loteFabricacao;
    }
    public void setDataValidade(LocalDate dataValidade){
        this.dataValidade = dataValidade;
    }
    public void setTipoEstoque(TipoEstoque tipoEstoque){
        this.tipoEstoque = tipoEstoque;
    }
}