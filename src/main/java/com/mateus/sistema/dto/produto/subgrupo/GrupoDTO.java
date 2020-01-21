package com.mateus.sistema.dto.produto.subgrupo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class GrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull(message = "Preenchimento obrigatório.")
	private String descricao;

	public GrupoDTO() {
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
