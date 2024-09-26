package br.edu.ifsp.bra.poliscientia.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.bra.poliscientia.Model.Aluno;

@RestController
public class ProfessorController {

    ArrayList<Aluno> listaAlunos = new ArrayList<>();

    
    public ProfessorController() {
        listaAlunos.add(new Aluno("Giovana", 17, "giovana@gmail.com", "IFSP-BRA", 12345));
        listaAlunos.add(new Aluno("Franciele", 18, "franciele@gmail.com", "IFSP-BRA", 67890));
    }

    @GetMapping("/api/professor/listaDeAlunos") 
    public List<Aluno> endPoint1() { 
        return listaAlunos; 
    } 
}

