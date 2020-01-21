package com.mateus.sistema.dto.response.produto;

import com.mateus.sistema.domain.produto.ProdutoSubgrupo;
import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.dto.EntidadeId;

public class SubgrupoResponseDTO extends EntidadeId {
	private static final long serialVersionUID = 1L;

	private String descricao;

	private GrupoResponseDTO grupo;

	public SubgrupoResponseDTO() {
	}

	public SubgrupoResponseDTO(Subgrupo subgrupo) {
		super(subgrupo.getId());
		this.descricao = subgrupo.getDescricao();
		this.grupo = new GrupoResponseDTO(subgrupo.getGrupo());
	}

	public SubgrupoResponseDTO(ProdutoSubgrupo obj) {
		super(obj.getSubgrupo().getId());
		this.descricao = obj.getSubgrupo().getDescricao();
		this.grupo = new GrupoResponseDTO(obj.getSubgrupo().getGrupo());
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GrupoResponseDTO getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoResponseDTO grupo) {
		this.grupo = grupo;
	}

}
