package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface PrecoRepository extends JpaRepository <Preco, Long> {

    Optional<Preco> findByValor(double valor);

    Optional<Preco> findByDataAlteracao(Date dataAlteracao);

    Optional<Preco> findByHoraAlteracao(Date horaAlteracao);
}
