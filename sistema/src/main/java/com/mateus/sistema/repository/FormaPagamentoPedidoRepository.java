package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.FormaPagamentoPedido;

@Repository
public interface FormaPagamentoPedidoRepository extends JpaRepository<FormaPagamentoPedido,Integer> {

}
