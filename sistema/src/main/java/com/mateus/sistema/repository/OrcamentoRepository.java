package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento,Long> {

}
