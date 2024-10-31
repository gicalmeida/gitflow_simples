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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsp.bra.poliscientia.Model.Professor;
import br.edu.ifsp.bra.poliscientia.Model.SalaVirtual;
import br.edu.ifsp.bra.poliscientia.repository.ProfessorRepository;
import br.edu.ifsp.bra.poliscientia.repository.SalaRepository;

@RestController
public class SalaController {
    @Autowired
    SalaRepository salaRepository;
    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping("/sala/listaSalas")
    public List<SalaVirtual> getAllSalaVirtual() {
        return (List<SalaVirtual>) salaRepository.findAll();
    }

    @GetMapping("/sala/buscarSala/{id_sala}")
    public SalaVirtual getProfessorById(@PathVariable("id_sala") int id_sala) {
        return salaRepository.findById(id_sala).orElse(null);
    }

    //com erro: 
    //quando crio a sala, mesmo colcoando os dados do professor, o campo fica como nulo
    @PostMapping("/sala")
     public SalaVirtual createSalaVirtual(@RequestBody SalaVirtual salaVirtual) {
     int idProfessor = salaVirtual.getProfessor().getId_professor();
     Professor prof = professorRepository.findById(idProfessor).get();
     salaVirtual.setProfessor(prof);
     return salaRepository.save(salaVirtual);
    }

    @PutMapping("/sala/editarSala/{id_sala}")
    public ResponseEntity<SalaVirtual> putMethodName(@PathVariable("id_sala") int id_sala,
            @RequestBody SalaVirtual sala) {
        Optional<SalaVirtual> salaExistente = salaRepository.findById(id_sala);

        if (salaExistente.isPresent()) {
            SalaVirtual salaAtualizada = salaExistente.get();
            salaAtualizada.setNome(sala.getNome());
            salaAtualizada.setDescricao(sala.getDescricao());

            salaRepository.save(salaAtualizada);

            return ResponseEntity.ok(salaAtualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/sala/removerSala/{id_sala}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable("id_sala") int id_sala) {
        if (salaRepository.existsById(id_sala)) {
            salaRepository.deleteById(id_sala);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
