package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.TipoPessoa;

public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	public Cliente() {
	}

	public Cliente(Integer id, String nome, String email, Calendar dataCadastro, String cpfCnpj, TipoPessoa tipo) {
		super(id, nome, email, dataCadastro, cpfCnpj, tipo);
	}

	
	
}
