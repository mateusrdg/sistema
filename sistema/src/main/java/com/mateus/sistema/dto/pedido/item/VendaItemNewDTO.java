package com.mateus.sistema.dto.pedido.item;

import com.mateus.sistema.domain.enums.TipoPreco;

public class VendaItemNewDTO extends PedidoItemNewDTO {
	private static final long serialVersionUID = 1L;

	private TipoPreco tipoPreco;

	public VendaItemNewDTO() {
	}

	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
}
