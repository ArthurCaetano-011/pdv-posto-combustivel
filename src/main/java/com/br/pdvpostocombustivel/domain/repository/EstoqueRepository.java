package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstoqueRepository extends JpaRepository <Estoque, Long> {

    Optional<Estoque> findByLoteFabricacao(String loteFabricacao);

    Optional<Estoque> findByLocalEndereco(String localEndereco);

    Optional<Estoque> findByDataValidade(String dataValidade);

    boolean existsByLoteFabricacao(String loteFabricacao);

    boolean existsByLocalEdereco(String localEndereco);

    boolean existsByDataValidade(String dataValidade);
}
