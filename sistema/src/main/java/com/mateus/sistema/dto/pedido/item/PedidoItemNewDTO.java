package com.mateus.sistema.dto.pedido.item;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.pedido.PedidoItem;
import com.mateus.sistema.dto.produto.BaseProdutoDTO;
import com.mateus.sistema.dto.produto.ProdutoDTO;

public class PedidoItemNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String referencia;
	private BaseProdutoDTO produto;
	private BigDecimal quantidade;
	private BigDecimal preco;
	private BigDecimal desconto;

	public PedidoItemNewDTO() {
	}

	public PedidoItemNewDTO(String referencia, BaseProdutoDTO produto, BigDecimal quantidade, BigDecimal preco, BigDecimal desconto) {
		this.referencia = referencia;
		this.produto = produto;
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
	}

	public PedidoItemNewDTO(PedidoItem item) {
		this.referencia = item.getProduto().getReferencia();
		this.produto = new ProdutoDTO(item.getProduto());
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

	public BaseProdutoDTO getProduto() {
		return produto;
	}

	public void ProdutoDTO(BaseProdutoDTO produto) {
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
