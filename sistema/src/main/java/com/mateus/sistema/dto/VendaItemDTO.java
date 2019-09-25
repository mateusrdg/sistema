package com.mateus.sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.VendaItem;

public class VendaItemDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String referencia;
	private String produto;
	private BigDecimal quantidade;
	private BigDecimal preco;
	private BigDecimal desconto;

	public VendaItemDTO() {
	}

	public VendaItemDTO(String referencia, String produto, BigDecimal quantidade, BigDecimal preco, BigDecimal desconto) {
		this.referencia = referencia;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}

	public VendaItemDTO(VendaItem item) {
		this.referencia = item.getProduto().getReferencia();
		this.produto = item.getProduto().getDescricao();
		this.quantidade = item.getQuantidade();
		this.preco = item.getPreco();
		this.desconto = item.getDesconto();
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
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

}
