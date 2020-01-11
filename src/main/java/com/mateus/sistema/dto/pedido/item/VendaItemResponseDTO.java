package com.mateus.sistema.dto.pedido.item;

import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.pedido.OrcamentoItem;
import com.mateus.sistema.domain.pedido.VendaItem;

public class VendaItemResponseDTO extends PedidoItemResponseDTO {
	private static final long serialVersionUID = 1L;
	private TipoPreco tipoPreco;

	public VendaItemResponseDTO(VendaItem item) {
		super(item);
	}

	public VendaItemResponseDTO(OrcamentoItem item) {
		super(item);
	}

	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
}
