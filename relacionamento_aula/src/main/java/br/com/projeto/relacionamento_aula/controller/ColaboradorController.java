package br.com.projeto.relacionamento_aula.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projeto.relacionamento_aula.model.Colaborador;
import br.com.projeto.relacionamento_aula.repository.ColaboradorRepository;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController {
    
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @GetMapping("/listar")
    private Iterable<Colaborador> listar(){
        return colaboradorRepository.findAll();
    }

    @PostMapping("/cadastrar")
    private Colaborador cadastrar(@RequestBody Colaborador colaborador){
        return colaboradorRepository.save(colaborador);
    }

}
