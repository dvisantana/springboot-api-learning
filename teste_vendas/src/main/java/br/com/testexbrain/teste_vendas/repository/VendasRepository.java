package br.com.testexbrain.teste_vendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.testexbrain.teste_vendas.models.Vendas;

@Repository
public interface VendasRepository extends JpaRepository<Vendas,Long>{}
