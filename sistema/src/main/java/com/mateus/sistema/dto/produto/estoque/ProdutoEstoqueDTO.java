package com.mateus.sistema.dto.produto.estoque;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.EntidadeBaseId;

public class ProdutoEstoqueDTO extends EntidadeBaseId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EstoqueDTO estoque;

	private BigDecimal quantidade;

	public ProdutoEstoqueDTO() {
	}

	public ProdutoEstoqueDTO(Long id, Estoque estoque, BigDecimal quantidade) {
		super(id);
		this.setEstoque(new EstoqueDTO(estoque));
		this.setQuantidade(quantidade);
	}
	
	public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
		super(produtoEstoque.getId());
		this.estoque = new EstoqueDTO(produtoEstoque.getEstoque());
		this.setQuantidade(produtoEstoque.getQuantidade());
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public EstoqueDTO getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueDTO estoque) {
		this.estoque = estoque;
	}
}
