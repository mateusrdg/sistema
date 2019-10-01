package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Produto;

public class BaseProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String referencia;
	private String descricao;
	

	public BaseProdutoDTO() {
	}

	public BaseProdutoDTO(Long id , String referencia, String descricao) {
		this.id = id;
		this.referencia = referencia;
		this.descricao = descricao;
	}

	public BaseProdutoDTO(Produto produto) {
		this.id = produto.getId();
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
