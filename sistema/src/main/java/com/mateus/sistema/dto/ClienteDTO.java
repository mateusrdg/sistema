package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.Cliente;
import com.mateus.sistema.domain.enums.TipoCliente;

public class ClienteDTO extends PessoaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private TipoCliente tipoCliente;
	
	public ClienteDTO() {
	}

	public ClienteDTO(Long id, String nome, String email,  Calendar dataCadastro, String cpfCnpj, Boolean ativo, TipoCliente tipo) {
		super(id, nome, email, cpfCnpj, dataCadastro, ativo);
		this.tipoCliente = tipo;
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
