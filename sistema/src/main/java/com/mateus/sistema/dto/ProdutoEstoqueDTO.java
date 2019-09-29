package com.mateus.sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.Estoque;
import com.mateus.sistema.domain.ProdutoEstoque;

public class ProdutoEstoqueDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;

	private BigDecimal quantidade;

	public ProdutoEstoqueDTO() {
	}

	public ProdutoEstoqueDTO(Estoque estoque, BigDecimal quantidade) {
		this.setId(estoque.getId());
		this.setDescricao(estoque.getDescricao());
		this.setQuantidade(quantidade);
	}
	
	public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
		this.setId(produtoEstoque.getEstoque().getId());
		this.setDescricao(produtoEstoque.getEstoque().getDescricao());
		this.setQuantidade(produtoEstoque.getQuantidade());
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
