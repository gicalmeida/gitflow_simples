package br.edu.ifsp.bra.poliscientia.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.bra.poliscientia.Model.Aluno;
import br.edu.ifsp.bra.poliscientia.repository.ProfessorRepository;

@RestController
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;

    ArrayList<Aluno> listaAlunos = new ArrayList<>();

    
    public ProfessorController() {
        listaAlunos.add(new Aluno("Giovana", 17, "giovana@gmail.com", "IFSP-BRA", 12345L));
        listaAlunos.add(new Aluno("Franciele", 18, "franciele@gmail.com", "IFSP-BRA", 67890L));
    }

    @GetMapping("/api/professor/listaDeAlunos") 
    public List<Aluno> endPoint1() { 
        return listaAlunos; 
    } 

    /*@GetMapping("/api/professor/buscarAluno{id_aluno}") 
    public Long endPoint2(@PathVariable("id_aluno") Long resultado){
        return resultado;
    }*/
}

