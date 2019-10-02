package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonIgnore
	@Transient
	//private Integer tipo;
	private String nome;
	private String email;
	private String cpfCnpj;
	private Calendar dataCadastro;
	
	private Boolean ativo;
	
	@Transient
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	@Transient
	private List<Telefone> telefones = new ArrayList<Telefone>();
	
	public Pessoa() {
	}

	public Pessoa(Long id,String nome, String email, Calendar dataCadastro, String cpfCnpj) {
		this.id = id;
		this.nome = nome;
		//this.tipo = (tipo == null) ? null : tipo.getCod();
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.cpfCnpj = cpfCnpj;
		this.ativo = true; 
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}	
	
//	public TipoPessoa getTipo() {
//		return TipoPessoa.toEnum(tipo);
//	}
//
//	public void setTipo(TipoPessoa tipo) {
//		this.tipo = tipo.getCod();
//	}
//	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean estado) {
		this.ativo = estado;
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
