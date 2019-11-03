package com.mateus.sistema.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;

@Repository
public interface FormaPagamentoCompraRepository extends JpaRepository<FormaPagamentoCompra,Long> {

}
