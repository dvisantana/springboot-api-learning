package br.com.testexbrain.teste_vendas.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


import br.com.testexbrain.teste_vendas.models.Vendas;
import br.com.testexbrain.teste_vendas.repository.VendasRepository;
import br.com.testexbrain.teste_vendas.services.VendasService;

@RestController
@RequestMapping("/vendas")
public class VendasController {
    
    @Autowired
    private VendasService vendasService;
    
    //Listar todas as Vendas
    @GetMapping("/listar")
    private Page<Vendas> listarVendas(@PageableDefault(page = 0, size = 10, sort = "data", direction = Sort.Direction.ASC) Pageable pageable){
        return vendasService.findAll(pageable);
    }

    //Listar venda pelo ID
    @GetMapping("/listar/{id}")
    private Vendas listarVendasPorId(@PathVariable(value = "id") Long id){
        return vendasService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
    }

    //Cadastrar venda
    @PostMapping("/cadastrar")
    private Vendas cadastrarVenda(@RequestBody Vendas vendas){
        vendas.setData(LocalDateTime.now(ZoneId.of("UTC")));
        return vendasService.save(vendas);
    }

    //Alterar venda
    @PutMapping("/alterar/{id}")
    private ResponseEntity<Object> alterarVenda(@PathVariable(value = "id") Long id,@RequestBody Vendas vendasDto){
        Optional<Vendas> vendasOptional = vendasService.findById(id);
        if(!vendasOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID de Venda não encontrada!");
        }

        var vendas = vendasOptional.get();
        vendas.setValor(vendasDto.getValor());
        vendas.setVendedor(vendasDto.getVendedor());
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.save(vendas));
    }

    //Deletar venda
    @DeleteMapping("/remover/{id}")
    private ResponseEntity<Object> deletarVenda(@PathVariable(value = "id") Long id){
        Optional<Vendas> vendasOptional = vendasService.findById(id);
        if(!vendasOptional.isPresent()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID de Venda não encontrada!");
        }

        vendasService.deleteById(id);        
        return ResponseEntity.status(HttpStatus.OK).body("Venda removida com sucesso!");
    }


}
