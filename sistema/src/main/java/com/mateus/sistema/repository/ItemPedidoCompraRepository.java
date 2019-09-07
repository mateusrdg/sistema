package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ItemPedidoCompra;

@Repository
public interface ItemPedidoCompraRepository extends JpaRepository<ItemPedidoCompra,Integer> {

}
