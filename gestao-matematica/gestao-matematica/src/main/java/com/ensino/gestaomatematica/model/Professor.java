package com.ensino.gestaomatematica.model;


import jakarta.persistence.Entity;

@Entity
public class Professor  extends Pessoa{
    private Double salario;

    public Professor(){}

    public Professor(String nome, String cpf, Double salario){
        super(nome, cpf);
        this.salario = salario;
    }

    public Double getSalario(){return salario;}
    public Double setSalario(Double salario){this.salario = salario;return salario;}





}
