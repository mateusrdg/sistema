package com.mateus.sistema.dto.pedido.item;

import java.math.BigDecimal;

public class CompraItemNewDTO extends PedidoItemNewDTO{
	private static final long serialVersionUID = 1L;
	
	private BigDecimal preco;

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
