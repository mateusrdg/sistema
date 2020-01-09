package com.mateus.sistema.dto.pedido.item;

import com.mateus.sistema.domain.pedido.CompraItem;

public class CompraItemDTO extends PedidoItemDTO {
	private static final long serialVersionUID = 1L;
	
	public CompraItemDTO(CompraItem item) {
		super(item);
	}

}
