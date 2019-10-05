package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.List;

import com.mateus.sistema.domain.enums.TipoFuncionario;

public class FuncionarioNewDTO extends PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoFuncionario tipoFuncionario;
	
	public FuncionarioNewDTO() {
		super();
	}

	public FuncionarioNewDTO(String nome, String email, String cpfCnpj, List<EnderecoNewDTO> enderecos,
			List<TelefoneNewDTO> telefones, TipoFuncionario tipoFuncionario) {
		super(nome, email, cpfCnpj, enderecos, telefones);
		this.tipoFuncionario = tipoFuncionario;
	}

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

}
