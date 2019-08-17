package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Calendar dataCadastro;
	private Boolean ativo;

	private SubGrupo subgrupo;
	
	private List<Preco> precos = new ArrayList<Preco>();

	private List<EstoqueProduto> estoquesProduto = new ArrayList<EstoqueProduto>();
	
	public Produto() {
	}

	public Produto(Integer id, String descricao, Calendar dataCadastro, Boolean ativo, SubGrupo subgrupo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
		this.subgrupo = subgrupo;
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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public SubGrupo getSubgrupo() {
		return subgrupo;
	}

	public void setSubgrupo(SubGrupo subgrupo) {
		this.subgrupo = subgrupo;
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}
	
	public List<EstoqueProduto> getEstoquesProduto() {
		return estoquesProduto;
	}

	public void setEstoquesProduto(List<EstoqueProduto> estoquesProduto) {
		this.estoquesProduto = estoquesProduto;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
