package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Produto;

public class BaseProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	

	public BaseProdutoDTO() {
	}

	public BaseProdutoDTO(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		
	}

	public BaseProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
