package com.mateus.sistema.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pedido.ParcelaCompra;

@Repository
public interface ParcelaCompraRepository extends JpaRepository<ParcelaCompra,Long> {

}
