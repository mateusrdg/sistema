package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
public class Produto implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Calendar dataCadastro;
	private Boolean ativo;

	@OneToMany(mappedBy = "produto")
	private List<Preco> precos = new ArrayList<Preco>();

	@OneToMany(mappedBy = "produto")
	private List<ProdutoEstoque> produtoEstoque = new ArrayList<ProdutoEstoque>();

	@OneToMany(mappedBy = "produto")
	private List<ProdutoSubgrupo> produtoSubgrupo = new ArrayList<ProdutoSubgrupo>();

	@Transient
	private List<PedidoItem> itens = new ArrayList<PedidoItem>();

	public Produto() {
	}

	public Produto(Integer id, String descricao, Calendar dataCadastro, Boolean ativo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
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

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	public List<ProdutoEstoque> getEstoquesProduto() {
		return produtoEstoque;
	}

	public void setEstoquesProduto(List<ProdutoEstoque> estoquesProduto) {
		this.produtoEstoque = estoquesProduto;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public List<ProdutoEstoque> getProdutoEstoque() {
		return produtoEstoque;
	}

	public void setProdutoEstoque(List<ProdutoEstoque> produtoEstoque) {
		this.produtoEstoque = produtoEstoque;
	}

	public List<ProdutoSubgrupo> getProdutoSubgrupo() {
		return produtoSubgrupo;
	}

	public void setProdutoSubgrupo(List<ProdutoSubgrupo> produtoSubgrupo) {
		this.produtoSubgrupo = produtoSubgrupo;
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
