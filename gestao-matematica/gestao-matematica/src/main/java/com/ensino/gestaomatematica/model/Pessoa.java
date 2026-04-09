package com.ensino.gestaomatematica.model;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    protected String nome;
    protected String cpf;


    //Construtor vazio para o Spring/JPA
    public Pessoa() {}

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Long getId() { return this.id; }
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome = nome;}
    public String getCpf() { return cpf; }
    public void setCpf(String cpf){this.cpf = cpf;}

}
