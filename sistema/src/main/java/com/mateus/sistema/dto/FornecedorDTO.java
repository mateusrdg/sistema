package com.mateus.sistema.dto;

import com.mateus.sistema.domain.Fornecedor;

public class FornecedorDTO {

	private Integer id;
	private String nome;

	public FornecedorDTO() {
	}

	public FornecedorDTO(Integer id, String nome, String email) {
		this.id = id;
		this.nome = nome;
	}

	public FornecedorDTO(Fornecedor fornecedor) {
		this.id = fornecedor.getId();
		this.nome = fornecedor.getNome();
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
