package com.mateus.sistema.dto.pedido.compra;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.mateus.sistema.dto.pedido.PedidoItemDTO;

public class CompraItemDTO extends PedidoItemDTO{
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Preenchimento obrigatório!")
	private BigDecimal preco;
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
