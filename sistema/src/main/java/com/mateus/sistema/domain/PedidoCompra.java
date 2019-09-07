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
@Table(name = "pedido_compra")
public class PedidoCompra extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedidoCompra> itens = new ArrayList<ItemPedidoCompra>();
	
	public PedidoCompra() {
	}
	
	public PedidoCompra(Integer id, Calendar data, Calendar hora, Fornecedor fornecedor, Funcionario vendedor) {
		super(id, data, hora);
		setFornecedor(fornecedor);
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<ItemPedidoCompra> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoCompra> itens) {
		this.itens = itens;
	}
}
