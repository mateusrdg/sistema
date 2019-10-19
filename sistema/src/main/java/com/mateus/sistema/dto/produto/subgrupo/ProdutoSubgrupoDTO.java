package com.mateus.sistema.dto.produto.subgrupo;

import java.io.Serializable;

import com.mateus.sistema.domain.Subgrupo;

public class ProdutoSubgrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
