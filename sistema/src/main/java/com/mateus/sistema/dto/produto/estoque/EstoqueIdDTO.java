package com.mateus.sistema.dto.produto.estoque;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.dto.EntidadeId;

public class EstoqueIdDTO extends EntidadeId {

	private static final long serialVersionUID = 1L;

	public EstoqueIdDTO() {
	}
	
	public EstoqueIdDTO(Estoque estoque) {
		super(estoque.getId());
	}
}
