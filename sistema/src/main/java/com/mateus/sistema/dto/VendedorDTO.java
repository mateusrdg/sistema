package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Funcionario;

public class VendedorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public VendedorDTO() {
	}

	public VendedorDTO(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
	}

	public VendedorDTO(Funcionario vendedor) {
		this.id = vendedor.getId();
		this.nome = vendedor.getNome();
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
}
