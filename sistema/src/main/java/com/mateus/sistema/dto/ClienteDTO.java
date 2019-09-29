package com.mateus.sistema.dto;

import java.io.Serializable;

import com.mateus.sistema.domain.Cliente;
import com.mateus.sistema.domain.enums.TipoCliente;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String cpfCnpj;
	private TipoCliente tipoCliente;
	
	public ClienteDTO() {	
	}
	
	public ClienteDTO(Long id, String nome, String email, String cpfCnpj, TipoCliente tipoCliente) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipoCliente = tipoCliente;
	}
	
	public ClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.email = cliente.getEmail();
		this.cpfCnpj = cliente.getCpfCnpj();
		this.tipoCliente = cliente.getTipoCliente();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getTipoCliente() {
		return tipoCliente.getDescricao();
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	
}
