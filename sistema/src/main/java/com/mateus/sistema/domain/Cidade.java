package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String codIBGE;
	
	private Estado estado;

	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public Cidade() {
	}

	public Cidade(Integer id, String nome, String codIBGE, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.codIBGE = codIBGE;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodIBGE() {
		return codIBGE;
	}

	public void setCodIBGE(String codIBGE) {
		this.codIBGE = codIBGE;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
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
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
