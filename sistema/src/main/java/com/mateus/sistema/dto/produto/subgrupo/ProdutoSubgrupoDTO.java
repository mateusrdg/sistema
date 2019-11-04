package com.mateus.sistema.dto.produto.subgrupo;

import java.io.Serializable;

import com.mateus.sistema.domain.produto.ProdutoSubgrupo;

public class ProdutoSubgrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private SubgrupoDTO subgrupo;
	
	public ProdutoSubgrupoDTO() {
	}

	public ProdutoSubgrupoDTO(ProdutoSubgrupo produtoSubgrupo) {
		this.id = produtoSubgrupo.getId();
		this.setSubgrupo(new SubgrupoDTO(produtoSubgrupo.getSubgrupo()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SubgrupoDTO getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(SubgrupoDTO subgrupo) {
		this.subgrupo = subgrupo;
	}

}
