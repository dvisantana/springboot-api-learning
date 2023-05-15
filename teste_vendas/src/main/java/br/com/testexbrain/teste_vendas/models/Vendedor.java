package br.com.testexbrain.teste_vendas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_vendedor")
@Getter
@Setter
public class Vendedor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVendedor;

    @Column(nullable = false)
    private String nome_vendedor;

}
