package com.mateus.sistema.dto.pessoa.cliente;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Cliente;
import com.mateus.sistema.domain.enums.TipoCliente;
import com.mateus.sistema.dto.pessoa.PessoaDTO;
import com.mateus.sistema.dto.pessoa.endereco.EnderecoDTO;
import com.mateus.sistema.dto.pessoa.telefone.TelefoneDTO;

public class ClienteDTO extends PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoCliente tipoCliente;

	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nome, String email, Calendar dataCadastro, String cpfCnpj, Boolean ativo,
			TipoCliente tipo, List<EnderecoDTO> enderecos, List<TelefoneDTO> telefones) {
		super(id, nome, email, cpfCnpj, dataCadastro, ativo, enderecos, telefones);
		this.tipoCliente = (tipo == null) ? null : tipo;
		//this.estado = (estado == null) ? null : estado.getCod();
	}

	public ClienteDTO(Cliente cliente) {
		super(cliente);
		this.tipoCliente = cliente.getTipoCliente();
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoFuncionario(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

}
