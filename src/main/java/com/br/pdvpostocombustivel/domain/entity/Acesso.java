package com.br.pdvpostocombustivel.domain.entity;

import com.br.pdvpostocombustivel.enums.TipoAcesso;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "acessos")
public class Acesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //atributos
    @Column(length = 30, nullable = false)
    private String usuario;

    @Column(length = 10,nullable = false)
    private String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_acesso",nullable = false,length = 30)
    private TipoAcesso tipoAcesso;

    protected Acesso() {}

    //construtor
    public Acesso(String usuario, String senha,TipoAcesso tipoAcesso){
        this.usuario = usuario;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
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
    public TipoAcesso getTipoAcesso(){
        return tipoAcesso;
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
    public void setTipoAcesso(TipoAcesso tipoAcesso){
        this.tipoAcesso = tipoAcesso;
    }
}