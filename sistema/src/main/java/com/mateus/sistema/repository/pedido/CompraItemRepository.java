package com.mateus.sistema.repository.pedido;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pedido.CompraItem;

@Repository
public interface CompraItemRepository extends JpaRepository<CompraItem,Long> {

}
