package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "pedido_compra_item")
public class ItemPedidoCompra extends ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_compra_id")
	private PedidoCompra pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public ItemPedidoCompra() {
	}

	public ItemPedidoCompra(Integer id, PedidoCompra pedido, Produto produto, BigDecimal quantidade, BigDecimal preco,
			BigDecimal desconto) {
		super(id, quantidade, preco, desconto);
		this.pedido = pedido;
		this.produto = produto;
	}

	public PedidoCompra getPedido() {
		return pedido;
	}

	public void setPedido(PedidoCompra pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
