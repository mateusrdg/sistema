package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.FormaPagamento;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento,Long> {

}
