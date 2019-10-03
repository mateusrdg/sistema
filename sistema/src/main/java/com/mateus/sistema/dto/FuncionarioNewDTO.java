package com.mateus.sistema.dto;

import java.io.Serializable;

public class FuncionarioNewDTO extends PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public FuncionarioNewDTO() {
		super();
	}

	public FuncionarioNewDTO(String nome, String email) {
		super(nome, email);
	}

}
