package com.mateus.sistema.dto.response.produto.estoque;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.dto.EntidadeId;

public class EstoqueResponseDTO extends EntidadeId {
	private static final long serialVersionUID = 1L;
	
	private String descricao;

	public EstoqueResponseDTO(Estoque estoque) {
		super(estoque.getId());
		this.descricao = estoque.getDescricao();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
