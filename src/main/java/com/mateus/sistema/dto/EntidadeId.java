package com.mateus.sistema.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class EntidadeId implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Preenchimento obrigatório.")
	private Long id;

	public EntidadeId() {
	}

	public EntidadeId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
