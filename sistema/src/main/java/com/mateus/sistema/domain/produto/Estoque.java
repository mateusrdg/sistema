package com.mateus.sistema.domain.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.pedido.EntradaEstoque;
import com.mateus.sistema.domain.pedido.PedidoItem;

@Entity(name = "Estoque")
@Table(name = "estoque")
public class Estoque implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;

	@JsonIgnore
	@OneToMany(mappedBy = "estoque")
	private List<ProdutoEstoque> estoqueProduto = new ArrayList<ProdutoEstoque>();

	@JsonIgnore
	@OneToMany(mappedBy = "estoque")
	private List<EntradaEstoque> entradas = new ArrayList<EntradaEstoque>();

	@JsonIgnore
	@Transient
	private List<PedidoItem> itens = new ArrayList<PedidoItem>();
	
	public Estoque() {
	}

	public Estoque(Long id) {
		this.id = id;
	}

	public Estoque(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
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
