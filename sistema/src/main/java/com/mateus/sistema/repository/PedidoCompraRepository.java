package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.PedidoCompra;

@Repository
public interface PedidoCompraRepository extends JpaRepository<PedidoCompra,Integer> {

}
