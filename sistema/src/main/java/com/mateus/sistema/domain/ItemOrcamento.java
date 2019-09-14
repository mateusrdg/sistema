package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="orcamento_item")
public class ItemOrcamento extends ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "orcamento_id")
	private Orcamento pedido;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public ItemOrcamento() {
	}

	public ItemOrcamento(Integer id, Orcamento pedido, Produto produto, BigDecimal quantidade, BigDecimal preco,
			BigDecimal desconto) {
		super(id, quantidade, preco, desconto);
		this.pedido = pedido;
		this.produto = produto;
	}

	public Orcamento getOrcamento() {
		return pedido;
	}

	public void setOrcamento(Orcamento pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
