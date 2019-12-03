package com.mateus.sistema.dto.produto.estoque;

import com.mateus.sistema.domain.produto.Estoque;

public class EstoqueDTO extends EstoqueIdDTO{
	private static final long serialVersionUID = 1L;
	
	private String descricao;

	public EstoqueDTO() {	
	}
	
	public EstoqueDTO(Estoque estoque) {	
		super(estoque);
		this.descricao = estoque.getDescricao();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
