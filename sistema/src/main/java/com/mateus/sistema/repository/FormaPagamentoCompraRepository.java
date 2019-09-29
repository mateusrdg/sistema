package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.FormaPagamentoCompra;

@Repository
public interface FormaPagamentoCompraRepository extends JpaRepository<FormaPagamentoCompra,Long> {

}
