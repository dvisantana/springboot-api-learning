package br.com.projeto.relacionamento_aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.relacionamento_aula.model.Cargo;
import br.com.projeto.relacionamento_aula.repository.CargoRepositorio;

@RestController
@RequestMapping("/cargos")
public class CargoController {
    
    @Autowired
    private CargoRepositorio cargoRepositorio;

    @GetMapping("/listar")
    private Iterable<Cargo> listar(){
        return cargoRepositorio.findAll();
    }

    @PostMapping("/cadastrar")
    private Cargo cadastrar(@RequestBody Cargo cargo){
        return cargoRepositorio.save(cargo);
    }
 
}
