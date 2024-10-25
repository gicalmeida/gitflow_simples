package br.edu.ifsp.bra.poliscientia.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.ifsp.bra.poliscientia.Model.SalaVirtual;

public interface SalaRepository extends CrudRepository<SalaVirtual, Integer> {
    
}
