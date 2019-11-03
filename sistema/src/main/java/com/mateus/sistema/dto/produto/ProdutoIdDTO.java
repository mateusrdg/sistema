package com.mateus.sistema.dto.produto;

import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.dto.EntidadeBaseId;

public class ProdutoIdDTO extends EntidadeBaseId {
	private static final long serialVersionUID = 1L;
	
	public ProdutoIdDTO() {
	}
	
	public ProdutoIdDTO(Long id) {
		super(id);
	}
	
	public ProdutoIdDTO(Produto produto) {
		super(produto.getId());
	}	
	
}
