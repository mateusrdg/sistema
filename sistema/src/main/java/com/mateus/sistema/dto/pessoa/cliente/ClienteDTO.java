package com.mateus.sistema.dto.pessoa.cliente;

import java.io.Serializable;

import com.mateus.sistema.domain.enums.TipoCliente;
import com.mateus.sistema.domain.pessoa.Cliente;
import com.mateus.sistema.dto.pessoa.PessoaDTO;
import com.mateus.sistema.services.validation.ClienteUpdate;
@ClienteUpdate
public class ClienteDTO extends PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoCliente tipoCliente;

	public ClienteDTO() {
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
