package com.mateus.sistema.dto;

import java.io.Serializable;

public class FornecedorNewDTO extends PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	public FornecedorNewDTO() {
		super();
	}

	public FornecedorNewDTO(String nome, String email) {
		super(nome, email);
	}

}
