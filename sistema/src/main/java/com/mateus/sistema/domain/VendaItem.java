package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name = "VendaItem")
@Table(name = "venda_item")
public class VendaItem extends PedidoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "venda_id", referencedColumnName = "id")
	private Venda pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public VendaItem() {
	}

	public VendaItem(Integer id, Venda pedido, Produto produto, BigDecimal quantidade, BigDecimal preco,BigDecimal desconto) {
		super(id, quantidade, preco, desconto);
		this.pedido = pedido;
		this.produto = produto;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Venda pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
}
