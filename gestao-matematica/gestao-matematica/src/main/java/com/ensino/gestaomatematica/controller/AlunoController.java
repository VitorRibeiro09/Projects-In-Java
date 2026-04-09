package com.ensino.gestaomatematica.controller;


import com.ensino.gestaomatematica.model.Aluno;
import com.ensino.gestaomatematica.repository.AlunoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")

public class AlunoController {


    private final AlunoRepository repository;

    public AlunoController(AlunoRepository repository) {
        this.repository = repository;
    }
@GetMapping
public List<Aluno> listarTodos(){
        return repository.findAll();
}


    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno novoAluno){
        return repository.save(novoAluno);
    }




}
