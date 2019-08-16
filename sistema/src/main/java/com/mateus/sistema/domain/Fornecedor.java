package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.TipoPessoa;

public class Fornecedor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nomeFantasia;

	public Fornecedor() {
	}

	public Fornecedor(Integer id, String nome, String email, Calendar dataCadastro, String cpfCnpj, TipoPessoa tipo, String nomeFantasia) {
		super(id, nome, email, dataCadastro, cpfCnpj, tipo);
		this.setNomeFantasia(nomeFantasia);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	
	
}
