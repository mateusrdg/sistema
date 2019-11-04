package com.mateus.sistema.dto.produto.subgrupo;

import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.dto.EntidadeBaseId;

public class SubgrupoDTO extends EntidadeBaseId {
	private static final long serialVersionUID = 1L;
	
	private String descricao;

	public SubgrupoDTO() {
	}
	
	public SubgrupoDTO(Long id, String descricao) {
		super(id);
		this.descricao = descricao;
	}
	
	public SubgrupoDTO(Subgrupo subgrupo) {
		super(subgrupo.getId());
		this.descricao = subgrupo.getDescricao();
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
