package com.br.pdvpostocombustivel.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.pdvpostocombustivel.domain.entity.Custo;

import java.time.LocalDate;
import java.util.Optional;

public interface CustoRepository extends JpaRepository  <Custo, Long> {

    Optional<Custo>findsByMargemLucro(double margemLucro);
    Optional<Custo>findsByMargemLucro(LocalDate dataProcessamento);

    boolean existsByMargemLucro(double margemLucro);
    boolean existByDataProcessamento(LocalDate dataProcessamento);
}
