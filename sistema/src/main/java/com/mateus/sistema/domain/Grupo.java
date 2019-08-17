package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	
	private List<SubGrupo> subGrupos = new ArrayList<SubGrupo>();
	
	public Grupo() {
	}

	public Grupo(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
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
	
	public List<SubGrupo> getSubGrupos() {
		return subGrupos;
	}

	public void setSubGrupos(List<SubGrupo> subGrupos) {
		this.subGrupos = subGrupos;
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
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
