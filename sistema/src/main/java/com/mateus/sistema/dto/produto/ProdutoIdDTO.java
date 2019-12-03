package com.mateus.sistema.dto.produto;

import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.dto.EntidadeId;

public class ProdutoIdDTO extends EntidadeId {
	private static final long serialVersionUID = 1L;
	
	public ProdutoIdDTO() {
	}
	
	public ProdutoIdDTO(Produto produto) {
		super(produto.getId());
	}	
	
}
