package com.mateus.sistema.dto.pessoa.telefone;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class TelefoneNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String numero;
	
	public TelefoneNewDTO() {
	}

	public TelefoneNewDTO(String numero) {
		this.numero = numero;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
