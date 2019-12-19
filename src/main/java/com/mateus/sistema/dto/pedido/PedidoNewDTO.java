package com.mateus.sistema.dto.pedido;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class PedidoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public PedidoNewDTO() {
	}
	
	public BigDecimal getValorTotal() {
		return calculaValorTotal();
	}
	
	public abstract BigDecimal calculaValorTotal();

	public abstract BigDecimal getValorTotalFormasPagamento();
	
}

