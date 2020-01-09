package com.mateus.sistema.dto.pedido.item;

import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.pedido.OrcamentoItem;
import com.mateus.sistema.domain.pedido.VendaItem;

public class VendaItemDTO extends PedidoItemDTO {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Preenchimento obrigatório.")
	private TipoPreco tipoPreco;

	public VendaItemDTO(VendaItem item) {
		super(item);
	}

	public VendaItemDTO(OrcamentoItem item) {
		super(item);
	}

	public TipoPreco getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(TipoPreco tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
}
