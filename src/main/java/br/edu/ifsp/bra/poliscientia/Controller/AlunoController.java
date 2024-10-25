package br.edu.ifsp.bra.poliscientia.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.bra.poliscientia.Model.Aluno;
import br.edu.ifsp.bra.poliscientia.repository.AlunoRepository;

@RestController
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    
}
