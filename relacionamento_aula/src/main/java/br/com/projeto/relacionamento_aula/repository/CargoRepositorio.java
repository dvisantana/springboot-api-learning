package br.com.projeto.relacionamento_aula.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.relacionamento_aula.model.Cargo;

@Repository
public interface CargoRepositorio extends CrudRepository<Cargo, Long>{
    
}
