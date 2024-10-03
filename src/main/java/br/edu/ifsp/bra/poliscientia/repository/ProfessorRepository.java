package br.edu.ifsp.bra.poliscientia.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.bra.poliscientia.Model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer>{
    
}
