package com.mateus.sistema.domain.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Subgrupo")
public class Subgrupo implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "grupo_id")
	private Grupo grupo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "subgrupo")
	private List<ProdutoSubgrupo> produtoSubgrupos = new ArrayList<ProdutoSubgrupo>();

	public Subgrupo() {
	}
	
	public Subgrupo(Long id) {
		this.id = id;
	}

	public Subgrupo(Long id, String descricao, Grupo grupo) {
		this.id = id;
		this.descricao = descricao;
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
	
	public List<ProdutoSubgrupo> getProdutoSubgrupos() {
		return produtoSubgrupos;
	}

	public void setProdutoSubgrupos(List<ProdutoSubgrupo> produtoSubgrupos) {
		this.produtoSubgrupos = produtoSubgrupos;
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
		Subgrupo other = (Subgrupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
