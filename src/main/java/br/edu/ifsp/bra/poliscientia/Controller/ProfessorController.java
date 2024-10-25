package br.edu.ifsp.bra.poliscientia.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import br.edu.ifsp.bra.poliscientia.Model.Aluno;
import br.edu.ifsp.bra.poliscientia.Model.Professor;
import br.edu.ifsp.bra.poliscientia.repository.ProfessorRepository;
import br.edu.ifsp.bra.poliscientia.repository.AlunoRepository;



@RestController
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/api/professor/listaDeAlunos")
    public List<Aluno> getAllAluno() {
        return (List<Aluno>) alunoRepository.findAll();
    }

    @GetMapping("/api/professor/buscarAluno/{id_aluno}")
    public Aluno getProfessorById(@PathVariable("id_aluno")Long id_aluno){
        return alunoRepository.findById((long) id_aluno).orElse(null);
    }

    @PostMapping("/api/professor")
    public Professor createProfessor(@RequestBody Professor professor){
    return professorRepository.save(professor);
    }

    //testar
    @PutMapping("/api/adicionarAluno/{id_aluno}")
    public ResponseEntity<Aluno> putMethodName(@PathVariable("id_aluno") Long id_aluno, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(id_aluno);
    
        if (alunoExistente.isPresent()) {
            Aluno alunoAtualizado = alunoExistente.get();
            alunoAtualizado.setNome(aluno.getNome());
            alunoAtualizado.setIdade(aluno.getIdade());
            alunoAtualizado.setEmail_aluno(aluno.getEmail_aluno());
            alunoAtualizado.setEscola(aluno.getEscola());
            alunoAtualizado.setPontuacao_total(aluno.getPontuacao_total());

            alunoRepository.save(alunoAtualizado);
            
            return ResponseEntity.ok(alunoAtualizado); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
     }
    
     //testar
    @DeleteMapping("/api/removerAluno/{id_aluno}")
        public ResponseEntity<Void> deleteAluno(@PathVariable("id_aluno") Long id_aluno) {
            if (alunoRepository.existsById(id_aluno)) {
                alunoRepository.deleteById(id_aluno);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        }
}
