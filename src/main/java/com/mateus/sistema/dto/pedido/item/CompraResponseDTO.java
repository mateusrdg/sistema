package com.mateus.sistema.dto.pedido.item;

import com.mateus.sistema.domain.pedido.CompraItem;

public class CompraResponseDTO extends PedidoItemResponseDTO {
	private static final long serialVersionUID = 1L;
	
	public CompraResponseDTO(CompraItem item) {
		super(item);
	}

}
