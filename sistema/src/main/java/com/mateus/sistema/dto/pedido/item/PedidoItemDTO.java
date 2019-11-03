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

	public PedidoItemDTO() {
	}

	public PedidoItemDTO(Long id, BaseProdutoDTO produto, BigDecimal quantidade, BigDecimal preco,
			BigDecimal desconto) {
		this.id = id;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}

	public PedidoItemDTO(PedidoItem item) {
		this.id = item.getId();
		this.produto = new BaseProdutoDTO(item.getProduto().getId(), item.getProduto().getReferencia(),
				item.getProduto().getDescricao());
		this.quantidade = item.getQuantidade();
		this.preco = item.getPreco();
		this.desconto = item.getDesconto();
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

}
