package com.mateus.sistema.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;

@Repository
public interface FormaPagamentoVendaRepository extends JpaRepository<FormaPagamentoVenda,Long> {

}
