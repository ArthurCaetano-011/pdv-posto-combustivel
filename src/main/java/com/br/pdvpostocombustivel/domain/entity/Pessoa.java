package com.br.pdvpostocombustivel.domain.entity; //Pacote que a classe vai receber
import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "pessoa")

public class Pessoa{

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 200, nullable = false)//Limita a 200 caracteres o campo / Jamais permite que o campo esteja vazio
    private String nomeCompleto;

    @Column(length = 14, nullable = false)
    private  String cpfCnpj;

    @Column(length = 10,nullable = false)
    private LocalDate dataNascimento;

    @Column(length = 12)
    private Integer numeroCtps;

    //construtor
    public Pessoa (String nomeCompleto, String cpfCnpj, LocalDate dataNascimento, Integer numeroCtps){
        this.nomeCompleto = nomeCompleto;
        this.cpfCnpj = cpfCnpj;
        this.dataNascimento = dataNascimento;
        this.numeroCtps = numeroCtps;
    }
    //construtor vazio
    public Pessoa(){

    }

    //getters
    public Long getId() {
        return Id;
    }

    public String getNomeCompleto(){ // Recebe o set e aplica
        return nomeCompleto;
    }

    public String getCpfCnpj(){
        return cpfCnpj;
    }

    public LocalDate getDataNascimento(){
        return dataNascimento;
    }

    public Integer getNumeroCtps(){
        return numeroCtps;
    }

    //setters
    public void setId(Long id) {
        Id = id;
    }

    public void setNomeCompleto(String nomeCompleto){ // Atribui parametros a assinatura vazia (void)
        this.nomeCompleto = nomeCompleto;
    }

    public void setCpfCnpj(String cpfCnpj){
        this.cpfCnpj = cpfCnpj;
    }

    public void setDataNascimento(LocalDate dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public void setNumeroCtps(Integer numeroCtps){
        this.numeroCtps = numeroCtps;
    }
}