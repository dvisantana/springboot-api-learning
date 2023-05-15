package br.com.testexbrain.teste_vendas.controllers;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.testexbrain.teste_vendas.models.Vendedor;
import br.com.testexbrain.teste_vendas.repository.VendasVendedor;
import br.com.testexbrain.teste_vendas.repository.VendedorRepository;
import br.com.testexbrain.teste_vendas.services.VendedorService;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping("/listar")
    private Iterable<Vendedor> listarVendedor(){
        return vendedorService.findAll();
    }

    @GetMapping("/resumo")
    private ResponseEntity<Object> resumoVendedor(String dataIn, String dataFim){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(vendedorService.resumoVendedores(LocalDate.parse(dataIn),LocalDate.parse(dataFim)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Erro! verifique os parametros informados (Padrão para datas: 'yyyy-MM-dd')");
        }
    }
    
}
