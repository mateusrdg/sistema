package com.mateus.sistema.dto.pedido.item;

import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.enums.TipoPreco;

public class VendaItemDTO extends PedidoItemDTO {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Preenchimento obrigatório.")
	private TipoPreco tipoPreco;

	public VendaItemDTO() {
	}

	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
}
