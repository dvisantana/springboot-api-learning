package br.com.testexbrain.teste_vendas.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.testexbrain.teste_vendas.models.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Long>{

    @Query("SELECT Vendedor.nome_vendedor as nomeVendedor, COALESCE(COUNT(Vendas.id_vendas), 0) as totalVendas, ROUND(COALESCE(AVG(Vendas.valor), 0),2) as media FROM Vendedor Vendedor LEFT JOIN Vendas Vendas ON Vendedor.idVendedor = Vendas.vendedor AND data >= :data1 AND data <= :data2 GROUP BY nomeVendedor")
    Iterable<VendasVendedor> resumoVendedores(LocalDateTime data1, LocalDateTime data2);

}
