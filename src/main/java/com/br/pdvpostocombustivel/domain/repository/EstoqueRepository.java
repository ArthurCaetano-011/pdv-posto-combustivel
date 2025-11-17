package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.domain.entity.Produto; // Importar Produto
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface EstoqueRepository extends JpaRepository <Estoque, Long> {

    Optional<Estoque> findByLoteFabricacao(String loteFabricacao);

    Optional<Estoque> findByLocalEndereco(String localEndereco);

    Optional<Estoque> findByDataValidade(Date dataValidade);

    Optional<Estoque> findByProduto(Produto produto); // Novo método

    boolean existsByLoteFabricacao(String loteFabricacao);

    boolean existsByLocalEndereco(String localEndereco);

    boolean existsByDataValidade(Date dataValidade);
}
