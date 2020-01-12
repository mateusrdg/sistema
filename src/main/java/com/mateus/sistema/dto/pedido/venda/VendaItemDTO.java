package com.mateus.sistema.dto.pedido.venda;

import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.dto.pedido.PedidoItemDTO;

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
