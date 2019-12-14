package com.mateus.sistema.dto.pedido.item;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.dto.produto.ProdutoIdDTO;
import com.mateus.sistema.dto.produto.estoque.EstoqueIdDTO;

public class PedidoItemNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String referencia;
	private ProdutoIdDTO produto;
	private BigDecimal quantidade;
	private BigDecimal desconto;
	private EstoqueIdDTO estoque;
	
	public PedidoItemNewDTO() {
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public ProdutoIdDTO getProduto() {
		return produto;
	}

	public void ProdutoDTO(ProdutoIdDTO produto) {
		this.produto = produto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public EstoqueIdDTO getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueIdDTO estoque) {
		this.estoque = estoque;
	}

}
