package com.mateus.sistema.dto.pessoa.cliente;

import java.io.Serializable;
import java.util.List;

import com.mateus.sistema.domain.enums.TipoCliente;
import com.mateus.sistema.dto.pessoa.PessoaNewDTO;
import com.mateus.sistema.dto.pessoa.endereco.EnderecoNewDTO;
import com.mateus.sistema.dto.pessoa.telefone.TelefoneNewDTO;

public class ClienteNewDTO extends PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoCliente tipoCliente;

	public ClienteNewDTO() {
		super();
	}

	public ClienteNewDTO(String nome, String email, String cpfCnpj, List<EnderecoNewDTO> enderecos,
			List<TelefoneNewDTO> telefones, TipoCliente tipoCliente) {
		super(nome, email, cpfCnpj, enderecos, telefones);
		this.tipoCliente = tipoCliente;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}
