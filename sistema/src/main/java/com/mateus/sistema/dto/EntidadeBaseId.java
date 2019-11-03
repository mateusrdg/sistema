package com.mateus.sistema.dto;

import java.io.Serializable;

public class EntidadeBaseId implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	public EntidadeBaseId() {
	}

	public EntidadeBaseId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
