package br.edu.ifsp.bra.poliscientia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.bra.poliscientia.Model.Professor;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Integer>{
    
}
