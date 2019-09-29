package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Produto;

public class BaseProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String descricao;
	

	public BaseProdutoDTO() {
	}

	public BaseProdutoDTO(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		
	}

	public BaseProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
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
