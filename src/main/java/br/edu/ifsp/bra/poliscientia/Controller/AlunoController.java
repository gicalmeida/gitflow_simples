package br.edu.ifsp.bra.poliscientia.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.bra.poliscientia.Model.Aluno;
import br.edu.ifsp.bra.poliscientia.Model.Professor;
import br.edu.ifsp.bra.poliscientia.repository.AlunoRepository;

@RestController
public class AlunoController {
    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/api/aluno/{id}/pontuacaoTotal")
    public int getPontuacaoTotal(@PathVariable Long id) {
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado")); 
        return aluno.getPontuacao_total();
    }

    
    /*@GetMapping("/api/aluno/pontuacao/{id_aluno}/{id_fase}")
    public ResponseEntity<Pontuacao> getPontuacao(@PathVariable("id_aluno") Long id_aluno, 
                                                    @PathVariable("id_fase") int id_fase) {
        Optional<Pontuacao> pontuacao = pontuacaoRepository.findByIdAlunoAndIdFase(id_aluno, id_fase);
        return pontuacao.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

   /*  @PostMapping("/api/professor")
    public Professor createProfessor(@RequestBody Professor professor){
    return professorRepository.save(professor);
    }
*/
    /*@PutMapping("/api/adicionarAluno/{id_aluno}")
    public ResponseEntity<Aluno> putMethodName(@PathVariable("id_aluno") Long id_aluno, @RequestBody Aluno aluno) {
        Optional<Aluno> alunoExistente = alunoRepository.findById(id_aluno);
    }*/
}
