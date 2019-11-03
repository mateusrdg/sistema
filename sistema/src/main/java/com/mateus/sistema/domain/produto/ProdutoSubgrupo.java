package com.mateus.sistema.domain.produto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ProdutoSubgrupo")
public class ProdutoSubgrupo implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "subgrupo_id")
	private Subgrupo subgrupo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	public ProdutoSubgrupo() {
	}

	public ProdutoSubgrupo(Long id, Subgrupo subgrupo, Produto produto) {
		this.id = id;
		this.subgrupo = subgrupo;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Subgrupo getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		ProdutoSubgrupo other = (ProdutoSubgrupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
