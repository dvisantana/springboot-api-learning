package br.com.testexbrain.teste_vendas.models;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_vendas")
@Getter
@Setter
public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_vendas;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private LocalDateTime data;

    @OneToOne
    @JoinColumn(name = "idVendedor", referencedColumnName = "idVendedor")
    private Vendedor vendedor;

    public void setData(LocalDateTime data){
        this.data = data;
    }
    
}
