package com.ensino.gestaomatematica.model;

import jakarta.persistence.Entity;

@Entity
public class Aluno extends Pessoa {
   private  String matricula;

   public Aluno() {}

    public Aluno(String nome, String cpf, String matricula){
       super(nome, cpf);
       this.matricula = matricula;
    }

    public String getMatricula(){return matricula;}
    public String setMatricula(String matricula){return this.matricula=matricula;}
}
