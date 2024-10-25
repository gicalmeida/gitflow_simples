package br.edu.ifsp.bra.poliscientia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.bra.poliscientia.Model.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Long>{
    
}
