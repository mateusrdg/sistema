package com.mateus.sistema.dto.pessoa.funcionario;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.enums.TipoFuncionario;
import com.mateus.sistema.domain.pessoa.Funcionario;
import com.mateus.sistema.dto.pessoa.PessoaDTO;
import com.mateus.sistema.dto.pessoa.endereco.EnderecoDTO;
import com.mateus.sistema.dto.pessoa.telefone.TelefoneDTO;

public class FuncionarioDTO extends PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoFuncionario tipoFuncionario;

	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Long id, String nome, String email, Calendar dataCadastro, String cpfCnpj, Boolean ativo,
			TipoFuncionario tipo, List<EnderecoDTO> enderecos, List<TelefoneDTO> telefones) {
		super(id, nome, email, cpfCnpj, dataCadastro, ativo, enderecos, telefones);
		this.tipoFuncionario = (tipo == null) ? null : tipo;
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
