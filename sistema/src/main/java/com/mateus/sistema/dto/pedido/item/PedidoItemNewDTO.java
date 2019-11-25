package com.mateus.sistema.dto.pedido.item;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.dto.produto.ProdutoIdDTO;

public class PedidoItemNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String referencia;
	private ProdutoIdDTO produto;
	private BigDecimal quantidade;
	private BigDecimal desconto;

	public PedidoItemNewDTO() {
	}

//	public PedidoItemNewDTO(PedidoItem item) {
//		this.referencia = item.getProduto().getReferencia();
//		this.produto = new ProdutoDTO(item.getProduto());
//		this.quantidade = item.getQuantidade();
//		this.desconto = item.getDesconto();
//	}

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

}
