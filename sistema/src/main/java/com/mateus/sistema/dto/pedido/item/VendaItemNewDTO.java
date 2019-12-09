package com.mateus.sistema.dto.pedido.item;

import com.mateus.sistema.dto.produto.preco.PrecoTipoDTO;

public class VendaItemNewDTO extends PedidoItemNewDTO{
	private static final long serialVersionUID = 1L;
	
	private PrecoTipoDTO tipoPreco;

	public PrecoTipoDTO getTipoPreco() {
		return tipoPreco;
	}

	public void setTipoPreco(PrecoTipoDTO tipoPreco) {
		this.tipoPreco = tipoPreco;
	}
	
}
