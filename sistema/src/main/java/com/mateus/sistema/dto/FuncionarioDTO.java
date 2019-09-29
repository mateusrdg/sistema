package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Funcionario;

public class FuncionarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;

	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
	}

	public FuncionarioDTO(Funcionario funcionario) {
		this.id = funcionario.getId();
		this.nome = funcionario.getNome();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
