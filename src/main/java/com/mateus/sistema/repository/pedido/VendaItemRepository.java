package com.mateus.sistema.repository.pedido;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;

@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem,Long> {
	
	List<VendaItem> findByPedido(Venda pedido);
}
