package com.ensino.gestaomatematica.repository;

import com.ensino.gestaomatematica.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {


}
