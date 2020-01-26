package com.mateus.sistema.dto.produto.estoque;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.EntidadeId;
import com.mateus.sistema.dto.response.produto.estoque.EstoqueResponseDTO;

public class ProdutoEstoqueDTO extends EntidadeId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EstoqueResponseDTO estoque;

	private BigDecimal quantidade;

	public ProdutoEstoqueDTO() {
	}

	public ProdutoEstoqueDTO(Long id, Estoque estoque, BigDecimal quantidade) {
		super(id);
		this.setEstoque(new EstoqueResponseDTO(estoque));
		this.setQuantidade(quantidade);
	}
	
	public ProdutoEstoqueDTO(ProdutoEstoque produtoEstoque) {
		super(produtoEstoque.getId());
		this.estoque = new EstoqueResponseDTO(produtoEstoque.getEstoque());
		this.setQuantidade(produtoEstoque.getQuantidade());
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public EstoqueResponseDTO getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueResponseDTO estoque) {
		this.estoque = estoque;
	}
}
