package com.mateus.sistema.dto.produto;

import com.mateus.sistema.domain.produto.Produto;

public class ProdutoIdDTO {
	
	private Long id;
	
	public ProdutoIdDTO() {
	}
	
	public ProdutoIdDTO(Long id) {
		this.id = id;
	}
	
	public ProdutoIdDTO(Produto produto) {
		this.id = produto.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
