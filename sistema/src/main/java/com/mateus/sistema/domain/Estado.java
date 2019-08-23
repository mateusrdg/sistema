package com.mateus.sistema.domain;

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

@Entity(name="estado")
public class Estado implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String codigoIBGE;
	private String sigla;
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	public Estado() {
	}

	public Estado(Integer id, String nome, String codigoIBGE, String sigla, Pais pais) {
		this.id = id;
		this.nome = nome;
		this.codigoIBGE = codigoIBGE;
		this.sigla = sigla;
		this.pais = pais;
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

	public String getcodigoIBGE() {
		return codigoIBGE;
	}

	public void setcodigoIBGE(String codIBGE) {
		this.codigoIBGE = codIBGE;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	//public List<Cidade> getCidades() {
	//	return cidades;
	//}

	//public void setCidades(List<Cidade> cidades) {
	//	this.cidades = cidades;
	//}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
