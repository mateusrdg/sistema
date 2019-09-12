package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.FormaPagamentoVenda;

@Repository
public interface FormaPagamentoVendaRepository extends JpaRepository<FormaPagamentoVenda,Integer> {

}
