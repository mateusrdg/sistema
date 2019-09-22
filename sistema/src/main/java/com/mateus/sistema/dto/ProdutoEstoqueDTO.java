package com.mateus.sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.Estoque;
import com.mateus.sistema.domain.ProdutoEstoque;

public class ProdutoEstoqueDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Estoque estoque;

	private BigDecimal quantidade;

	public ProdutoEstoqueDTO() {
	}

	public ProdutoEstoqueDTO(Estoque estoque, BigDecimal quantidade) {
		this.setEstoque(estoque);
		this.setQuantidade(quantidade);
	}
	
	public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
		this.setEstoque(produtoEstoque.getEstoque());
		this.setQuantidade(produtoEstoque.getQuantidade());
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
}
