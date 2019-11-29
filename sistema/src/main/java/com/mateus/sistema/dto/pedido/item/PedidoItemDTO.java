package com.mateus.sistema.dto.pedido.item;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.pedido.PedidoItem;
import com.mateus.sistema.dto.produto.BaseProdutoDTO;

public class PedidoItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private BaseProdutoDTO produto;
	private BigDecimal quantidade;
	private BigDecimal preco;
	private BigDecimal desconto;
	private BigDecimal total;

	public PedidoItemDTO() {
	}

	public PedidoItemDTO(PedidoItem item) {
		this.id = item.getId();
		this.produto = new BaseProdutoDTO(item.getProduto());
		this.quantidade = item.getQuantidade();
		this.preco = item.getPreco();
		this.desconto = item.getDesconto();
		this.total = item.getTotal();
	}

	public BaseProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(BaseProdutoDTO produto) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
