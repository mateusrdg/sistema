package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private Pedido pedido;
	private Produto produto;
	
	private BigDecimal quantidade;
	private BigDecimal preco;
	private BigDecimal desconto;
	
	public ItemPedido() {
	}
	
	public ItemPedido(Integer id, Pedido pedido, Produto produto, BigDecimal quantidade, BigDecimal preco, BigDecimal desconto) {
		this.id = id;
		this.pedido = pedido;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
