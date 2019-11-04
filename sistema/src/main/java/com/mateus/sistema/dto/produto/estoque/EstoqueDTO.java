package com.mateus.sistema.dto.produto.estoque;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.dto.EntidadeBaseId;

public class EstoqueDTO extends EntidadeBaseId{
	private static final long serialVersionUID = 1L;
	
	private String descricao;

	public EstoqueDTO() {	
	}
	
	public EstoqueDTO(Long id, String descricao) {	
		super(id);
		this.descricao = descricao;
	}
	
	public EstoqueDTO(Estoque estoque) {	
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
