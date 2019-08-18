package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.TipoPedidoVenda;

public class PedidoCompra extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Fornecedor fornecedor;
	
	public PedidoCompra() {
	}
	
	public PedidoCompra(Integer id, Calendar data, Calendar hora, Fornecedor fornecedor, TipoPedidoVenda tipo, Funcionario vendedor) {
		super(id, data, hora);
		setFornecedor(fornecedor);
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
}
