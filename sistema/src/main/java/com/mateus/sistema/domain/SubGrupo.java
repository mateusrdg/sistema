package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubGrupo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Grupo grupo;

	private List<Produto> produtos = new ArrayList<Produto>();

	public SubGrupo() {
	}

	public SubGrupo(Integer id, String descricao, Grupo grupo) {
		this.id = id;
		this.descricao = descricao;
		this.grupo = grupo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubGrupo other = (SubGrupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
