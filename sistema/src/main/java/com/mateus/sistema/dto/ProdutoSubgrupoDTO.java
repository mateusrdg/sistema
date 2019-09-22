package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Subgrupo;

public class ProdutoSubgrupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Subgrupo subgrupo;

	public ProdutoSubgrupoDTO() {
	}

	public ProdutoSubgrupoDTO(Subgrupo subgrupo) {
		this.setSubgrupo(subgrupo);
	}

	public Subgrupo getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

}
