package com.mateus.sistema.dto.pedido.item;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.dto.produto.ProdutoIdDTO;
import com.mateus.sistema.dto.produto.estoque.EstoqueIdDTO;

public class PedidoItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@Valid
	@NotNull(message = "preenchimento obrigatóprio")
	private ProdutoIdDTO produto;
	@NotNull(message = "Preenchimento obrigatório!")
	private BigDecimal quantidade;
	@NotNull(message = "Preenchimento obrigatório!")
	private BigDecimal desconto;
	@Valid
	@NotNull(message = "preenchimento obrigatóprio")
	private EstoqueIdDTO estoque;	
	
	public PedidoItemDTO() {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
