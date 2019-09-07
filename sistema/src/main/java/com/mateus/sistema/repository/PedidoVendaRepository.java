package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.PedidoVenda;

@Repository
public interface PedidoVendaRepository extends JpaRepository<PedidoVenda,Integer> {

}
