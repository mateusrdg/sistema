package com.mateus.sistema.dto.response.pedido.compra;

import com.mateus.sistema.domain.pedido.CompraItem;
import com.mateus.sistema.dto.response.pedido.PedidoItemResponseDTO;

public class CompraItemResponseDTO extends PedidoItemResponseDTO {
	private static final long serialVersionUID = 1L;
	
	public CompraItemResponseDTO(CompraItem item) {
		super(item);
	}

}
