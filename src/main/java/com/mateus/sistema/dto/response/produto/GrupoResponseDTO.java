package com.mateus.sistema.dto.response.produto;

import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.EntidadeId;

public class GrupoResponseDTO extends EntidadeId {
	private static final long serialVersionUID = 1L;

	private String descricao;

	public GrupoResponseDTO() {
	}

	public GrupoResponseDTO(Grupo grupo) {
		super(grupo.getId());
		this.descricao = grupo.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
