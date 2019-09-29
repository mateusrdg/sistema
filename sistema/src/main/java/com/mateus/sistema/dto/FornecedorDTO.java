package com.mateus.sistema.dto;

import com.mateus.sistema.domain.Fornecedor;

public class FornecedorDTO {

	private Long id;
	private String nome;

	public FornecedorDTO() {
	}

	public FornecedorDTO(Long id, String nome, String email) {
		this.id = id;
		this.nome = nome;
	}

	public FornecedorDTO(Fornecedor fornecedor) {
		this.id = fornecedor.getId();
		this.nome = fornecedor.getNome();
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
