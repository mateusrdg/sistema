package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.TipoPedidoVenda;

public class PedidoVenda extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Cliente cliente;
	private Integer tipo;
	private Funcionario vendedor;
	
	public PedidoVenda() {
	}
	
	public PedidoVenda(Integer id, Calendar data, Calendar hora, Cliente cliente, TipoPedidoVenda tipo, Funcionario vendedor) {
		super(id, data, hora);
		this.setCliente(cliente);
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.vendedor = vendedor;
	}
	
	public TipoPedidoVenda getTipoPedido () {
		return TipoPedidoVenda.toEnum(this.tipo);
	}
	
	public void setTipoPedido (TipoPedidoVenda tipo) {
		this.tipo = tipo.getCod();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}
	
}
