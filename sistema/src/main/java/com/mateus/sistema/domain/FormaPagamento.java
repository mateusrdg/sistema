package com.mateus.sistema.domain;

import java.io.Serializable;

import com.mateus.sistema.domain.enums.TipoFormaPagamento;

public class FormaPagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Integer tipo;

	public FormaPagamento() {
	}

	public FormaPagamento(Integer id, String descricao, TipoFormaPagamento tipo) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = (tipo == null) ? null : tipo.getCod();
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

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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
		FormaPagamento other = (FormaPagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
