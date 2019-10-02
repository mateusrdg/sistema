package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.Funcionario;
import com.mateus.sistema.domain.enums.TipoFuncionario;

public class FuncionarioDTO extends PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoFuncionario tipoFuncionario;
	
	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Long id, String nome, String email,  Calendar dataCadastro, String cpfCnpj, Boolean ativo, TipoFuncionario tipo) {
		super(id, nome, email, cpfCnpj, dataCadastro, ativo);
		this.tipoFuncionario = tipo;
	}

	public FuncionarioDTO(Funcionario funcionario) {
		super(funcionario);		
		this.tipoFuncionario = funcionario.getTipoFuncionario();
	}

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
}
