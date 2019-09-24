package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Subgrupo;

public class ProdutoSubgrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	
	public ProdutoSubgrupoDTO() {
	}

	public ProdutoSubgrupoDTO(Subgrupo subgrupo) {
		this.setId(subgrupo.getId());
		this.setDescricao(subgrupo.getDescricao());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
