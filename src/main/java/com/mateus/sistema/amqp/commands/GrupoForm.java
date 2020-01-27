package com.mateus.sistema.amqp.commands;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.produto.Grupo;

public class GrupoForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotNull(message = "Preenchimento obrigatório.")
	private String descricao;

	public GrupoForm() {
	}
	
	public GrupoForm(Grupo grupo) {
		this.id = grupo.getId();
		this.descricao = grupo.getDescricao();
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

}
