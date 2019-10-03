package com.mateus.sistema.dto;

import java.io.Serializable;

public class ClienteNewDTO extends PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public ClienteNewDTO() {
		super();
	}

	public ClienteNewDTO(String nome, String email) {
		super(nome, email);
	}

}
