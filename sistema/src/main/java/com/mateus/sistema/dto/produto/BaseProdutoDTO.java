package com.mateus.sistema.dto.produto;

import java.io.Serializable;

import com.mateus.sistema.domain.produto.Produto;

public class BaseProdutoDTO extends ProdutoIdDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String referencia;
	private String descricao;

	public BaseProdutoDTO() {
	}

	public BaseProdutoDTO(Produto produto) {
		super(produto);
		this.referencia = produto.getReferencia();
		this.descricao = produto.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
