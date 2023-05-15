package br.com.testexbrain.teste_vendas.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testexbrain.teste_vendas.models.Vendedor;
import br.com.testexbrain.teste_vendas.repository.VendasVendedor;
import br.com.testexbrain.teste_vendas.repository.VendedorRepository;

@Service
public class VendedorService {
    
    @Autowired
    private VendedorRepository vendedorRepository;

    public Iterable<Vendedor> findAll(){
        return vendedorRepository.findAll();
    }

    public Optional<Vendedor> findById(Long id){
        return vendedorRepository.findById(id);
    }

    public Vendedor save(Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    public void deleteById(Long id){
        vendedorRepository.deleteById(id);
    }

    public Iterable<VendasVendedor> resumoVendedores(LocalDate dataIn, LocalDate dataFim){
        return vendedorRepository.resumoVendedores(dataIn.atStartOfDay(),dataFim.atStartOfDay());
    }


}
