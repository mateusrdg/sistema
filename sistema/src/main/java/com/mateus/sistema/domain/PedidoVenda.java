package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_venda")
public class PedidoVenda extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario vendedor;

	@OneToMany(mappedBy = "pedido")
	private List<ItemPedidoVenda> itens = new ArrayList<ItemPedidoVenda>();

	public PedidoVenda() {
	}

	public PedidoVenda(Integer id, Calendar data, Calendar hora, Cliente cliente, Funcionario vendedor) {
		super(id, data, hora);
		this.setCliente(cliente);
		this.vendedor = vendedor;
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

	public List<ItemPedidoVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoVenda> itens) {
		this.itens = itens;
	}
}
