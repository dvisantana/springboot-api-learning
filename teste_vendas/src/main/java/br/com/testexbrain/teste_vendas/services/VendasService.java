package br.com.testexbrain.teste_vendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.testexbrain.teste_vendas.models.Vendas;
import br.com.testexbrain.teste_vendas.repository.VendasRepository;

@Service
public class VendasService {
    
    @Autowired
    private VendasRepository vendasRepository;

    public Page<Vendas> findAll(Pageable pageable){
        return vendasRepository.findAll(pageable);
    }

    public Optional<Vendas> findById(Long id){
        return vendasRepository.findById(id);
    }

    @Transactional
    public Vendas save(Vendas vendas){
        return vendasRepository.save(vendas);
    }

    @Transactional
    public void deleteById(Long id){
        vendasRepository.deleteById(id);
    }

}
