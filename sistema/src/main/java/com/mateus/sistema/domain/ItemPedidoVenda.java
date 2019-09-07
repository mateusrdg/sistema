package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "pedido_venda_item")
public class ItemPedidoVenda extends ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "pedido_venda_id", referencedColumnName = "id")
	private PedidoVenda pedido;
	
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	public ItemPedidoVenda() {
	}

	public ItemPedidoVenda(Integer id, PedidoVenda pedido, Produto produto, BigDecimal quantidade, BigDecimal preco,BigDecimal desconto) {
		super(id, quantidade, preco, desconto);
		this.pedido = pedido;
		this.produto = produto;
	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(PedidoVenda pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	
}
