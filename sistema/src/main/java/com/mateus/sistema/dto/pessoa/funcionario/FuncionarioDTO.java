package com.mateus.sistema.dto.pessoa.funcionario;

import java.io.Serializable;

import com.mateus.sistema.domain.enums.TipoFuncionario;
import com.mateus.sistema.domain.pessoa.Funcionario;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class FuncionarioDTO extends PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoFuncionario tipoFuncionario;

	public FuncionarioDTO() {
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
