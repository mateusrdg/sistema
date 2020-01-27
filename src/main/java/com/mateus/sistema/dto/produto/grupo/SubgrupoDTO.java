package com.mateus.sistema.dto.produto.grupo;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SubgrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull(message = "Preenchimento obrigatório.")
	private String descricao;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private GrupoIdDTO grupo;

	public SubgrupoDTO() {
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

	public GrupoIdDTO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoIdDTO grupo) {
		this.grupo = grupo;
	}

}
