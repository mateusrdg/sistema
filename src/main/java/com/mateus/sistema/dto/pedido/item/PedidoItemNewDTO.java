package com.mateus.sistema.dto.pedido.item;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.dto.produto.ProdutoIdDTO;
import com.mateus.sistema.dto.produto.estoque.EstoqueIdDTO;

public class PedidoItemNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Valid
	@NotNull(message = "preenchimento obrigatóprio")
	private ProdutoIdDTO produto;
	//@NotNull(message = "Preenchimento obrigatório!")
	private BigDecimal preco;
	@NotNull(message = "Preenchimento obrigatório!")
	private BigDecimal quantidade;
	@NotNull(message = "Preenchimento obrigatório!")
	private BigDecimal desconto;
	@Valid
	@NotNull(message = "preenchimento obrigatóprio")
	private EstoqueIdDTO estoque;	
	
	public PedidoItemNewDTO() {
	}

	public ProdutoIdDTO getProduto() {
		return produto;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
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
	
	@JsonIgnore
	private BigDecimal calculaTotal() {
		return (this.preco.multiply(this.quantidade).subtract(this.desconto));
	}
	@JsonIgnore
	public BigDecimal getTotal() {
		return calculaTotal();
	}

}
