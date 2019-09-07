package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ItemPedidoVenda;

@Repository
public interface ItemPedidoVendaRepository extends JpaRepository<ItemPedidoVenda,Integer> {

}
