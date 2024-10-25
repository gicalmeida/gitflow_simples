package br.edu.ifsp.bra.poliscientia.Controller;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

import br.edu.ifsp.bra.poliscientia.Model.Professor;
import br.edu.ifsp.bra.poliscientia.Model.SalaVirtual;
import br.edu.ifsp.bra.poliscientia.repository.ProfessorRepository;


@RestController
public class ProfessorController {
    @Autowired
    ProfessorRepository professorRepository;


    @GetMapping("/professor/listaDeProfessores")
    public List<Professor> getAllProfessor() {
        return (List<Professor>) professorRepository.findAll();
    }

    @GetMapping("/professor/buscarProfessor/{id_professor}")
    public Professor getProfessorById(@PathVariable("id_professor")int id_professor){
        return professorRepository.findById(id_professor).orElse(null);
    }

    @PostMapping("/professor")
    public Professor createProfessor(@RequestBody Professor professor){
        List<SalaVirtual> salasVirtuais = professor.getSala();
        for(SalaVirtual salaVirtual : salasVirtuais){
            salaVirtual.setProfessor(professor);
        }
        return professorRepository.save(professor);
    }

    //testar
    @PutMapping("/professor/adicionarProfessor/{id_professor}")
    public ResponseEntity<Professor> putMethodName(@PathVariable("id_professor") int id_professor, @RequestBody Professor professor) {
        Optional<Professor> professorExistente = professorRepository.findById(id_professor);
    
        if (professorExistente.isPresent()) {
            Professor professorAtualizado = professorExistente.get();
            professorAtualizado.setNome_professor(professor.getNome_professor());
            professorAtualizado.setEmail_professor(professor.getEmail_professor());
            professorAtualizado.setIdade(professor.getIdade());
            professorAtualizado.setEscola(professor.getEscola());

            professorRepository.save(professorAtualizado);
            
            return ResponseEntity.ok(professorAtualizado); 
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
        }
     }
    
     //testar
    @DeleteMapping("/removerProfessor/{id_professor}")
        public ResponseEntity<Void> deleteProfessor(@PathVariable("id_professor") int id_professor){
                if (professorRepository.existsById(id_professor)) {
                    professorRepository.deleteById(id_professor);
                    return ResponseEntity.noContent().build();
                } else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
        }
}
