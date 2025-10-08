package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    private String usuario;
    private String senha;

    protected Acesso() {}

    //construtor
    public Acesso(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    //getters
    public String getUsuario(){
        return usuario;
    }
    public String getSenha(){
        return senha;
    }
    public Long getId(){
        return id;
    }

    //setters
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setId(Long id){
        this.id = id;
    }
}