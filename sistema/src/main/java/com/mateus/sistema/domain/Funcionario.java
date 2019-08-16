package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.TipoFuncionario;
import com.mateus.sistema.domain.enums.TipoPessoa;

public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer tipo;
	
	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String email, Calendar dataCadastro, String cpfCnpj, TipoPessoa tipo, TipoFuncionario tipoFuncionario) {
		super(id, nome, email, dataCadastro, cpfCnpj, tipo);
		this.tipo = (tipoFuncionario == null) ? null : tipoFuncionario.getCod(); 
	}

	public TipoFuncionario getTipo() {
		return TipoFuncionario.toEnum(tipo);
	}

	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo.getCod();
	}
	
}
