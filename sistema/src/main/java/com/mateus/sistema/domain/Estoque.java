package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity(name = "estoque")
public class Estoque implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;

	@OneToMany(mappedBy = "estoque")
	private List<ProdutoEstoque> estoqueProduto = new ArrayList<ProdutoEstoque>();

	@OneToMany(mappedBy = "estoque")
	private List<EntradaEstoque> entradas = new ArrayList<EntradaEstoque>();

	public Estoque() {
	}

	public Estoque(Integer id, String descricao) {
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

	public List<ProdutoEstoque> getEstoqueProduto() {
		return estoqueProduto;
	}

	public void setEstoqueProduto(List<ProdutoEstoque> estoqueProduto) {
		this.estoqueProduto = estoqueProduto;
	}

	public List<EntradaEstoque> getEntradas() {
		return entradas;
	}

	public void setEntradas(List<EntradaEstoque> entradas) {
		this.entradas = entradas;
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
		Estoque other = (Estoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
