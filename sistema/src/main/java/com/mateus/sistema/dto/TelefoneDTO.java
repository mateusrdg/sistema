package com.mateus.sistema.dto;

import java.io.Serializable;

public class TelefoneDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String numero;
	
	public TelefoneDTO() {
	}

	public TelefoneDTO(Long id, String numero) {
		this.id = id;
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
