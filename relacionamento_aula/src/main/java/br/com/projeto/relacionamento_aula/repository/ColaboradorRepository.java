package br.com.projeto.relacionamento_aula.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.relacionamento_aula.model.Colaborador;

@Repository
public interface ColaboradorRepository extends CrudRepository<Colaborador, Long>{
    
}
