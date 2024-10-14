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

    AlunoRepository alunoRepository;

    ArrayList<Aluno> listaAlunos = new ArrayList<>();

    
   /*  public ProfessorController() {
        listaAlunos.add(new Aluno("Giovana", 17, "giovana@gmail.com", "IFSP-BRA", 12345L));
        listaAlunos.add(new Aluno("Franciele", 18, "franciele@gmail.com", "IFSP-BRA", 67890L));
    }*/

    @GetMapping("/api/professor/listaDeAlunos")
    public List<Aluno> getAllAluno() {
        return (List<Aluno>)alunoRepository.findAll();
    }

    @GetMapping("/api/professor/buscarAluno/{id_aluno}")
    public Aluno getProfessorById(@PathVariable("id_aluno")int id_aluno){
        return alunoRepository.findById((long) id_aluno).get();
    }

    @PostMapping("/api/professor")
    public Professor createProfessor(@RequestBody Professor professor){
    return professorRepository.save(professor);
    }

    @PutMapping("/api/adicionarAluno/{id_aluno}")
    public ResponseEntity<Aluno> putMethodName(@PathVariable("id_aluno") Long id_aluno, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(id_aluno);
        
        if (alunoExistente.isPresent()) {
            // Atualiza o aluno existente
            Aluno alunoAtualizado = alunoExistente.get();
            alunoAtualizado.setNome(aluno.getNome());
            alunoAtualizado.setEmail_aluno(aluno.getEmail_aluno());
            alunoAtualizado.setIdade(aluno.getIdade());
            alunoAtualizado.setEscola(aluno.getEscola());
            alunoAtualizado.setSenha(aluno.getSenha());

            Aluno alunoSalvo = alunoRepository.save(alunoAtualizado); // Salva as alterações no banco de dados
            return ResponseEntity.ok(alunoSalvo); // Retorna 200 OK com o aluno atualizado
        } else {
            // Cria um novo aluno, se não encontrado
            aluno.setId_aluno(id_aluno); // Define o ID para o novo aluno
            Aluno novoAluno = alunoRepository.save(aluno); // Salva o novo aluno no banco de dados
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno); // Retorna 201 Created com o novo aluno
        }
    }

    /*@DeleteMapping ("/api/removerAluno/{email_aluno}")
    public Aluno ()*/


}

