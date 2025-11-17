package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.FormaPagamento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String operador;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "bomba_id", nullable = false)
    private Bomba bomba;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Positive
    @Column(nullable = false)
    private BigDecimal litros;

    @Positive
    @Column(nullable = false)
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id") // Pode ser nulo
    private Pessoa cliente;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;

    @NotNull
    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @NotNull
    @Column(name = "hora_venda", nullable = false)
    private LocalTime horaVenda;

    @Column(name = "numero_nfce")
    private Long numeroNfce;

    @Column(name = "chave_acesso_nfce", length = 44)
    private String chaveAcessoNfce;

    // Construtor padrão para JPA
    protected Venda() {}

    public Venda(String operador, Bomba bomba, Produto produto, BigDecimal litros, BigDecimal valorTotal, Pessoa cliente, FormaPagamento formaPagamento, LocalDate dataVenda, LocalTime horaVenda) {
        this.operador = operador;
        this.bomba = bomba;
        this.produto = produto;
        this.litros = litros;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        this.dataVenda = dataVenda;
        this.horaVenda = horaVenda;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getOperador() { return operador; }
    public void setOperador(String operador) { this.operador = operador; }
    public Bomba getBomba() { return bomba; }
    public void setBomba(Bomba bomba) { this.bomba = bomba; }
    public Produto getProduto() { return produto; }
    public void setProduto(Produto produto) { this.produto = produto; }
    public BigDecimal getLitros() { return litros; }
    public void setLitros(BigDecimal litros) { this.litros = litros; }
    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }
    public Pessoa getCliente() { return cliente; }
    public void setCliente(Pessoa cliente) { this.cliente = cliente; }
    public FormaPagamento getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(FormaPagamento formaPagamento) { this.formaPagamento = formaPagamento; }
    public LocalDate getDataVenda() { return dataVenda; }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda = dataVenda; }
    public LocalTime getHoraVenda() { return horaVenda; }
    public void setHoraVenda(LocalTime horaVenda) { this.horaVenda = horaVenda; }
    public Long getNumeroNfce() { return numeroNfce; }
    public void setNumeroNfce(Long numeroNfce) { this.numeroNfce = numeroNfce; }
    public String getChaveAcessoNfce() { return chaveAcessoNfce; }
    public void setChaveAcessoNfce(String chaveAcessoNfce) { this.chaveAcessoNfce = chaveAcessoNfce; }
}
