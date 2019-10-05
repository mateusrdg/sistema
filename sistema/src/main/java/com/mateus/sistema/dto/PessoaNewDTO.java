package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres")
	private String nome;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String email;
	private String cpfCnpj;

	private List<EnderecoNewDTO> enderecos = new ArrayList<EnderecoNewDTO>();
	private List<TelefoneNewDTO> telefones = new ArrayList<TelefoneNewDTO>();
	
	public PessoaNewDTO() {
	}

	public PessoaNewDTO(String nome, String email, String cpfCnpj, List<EnderecoNewDTO> enderecos, List<TelefoneNewDTO> telefones) {
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.enderecos = enderecos;
		this.telefones = telefones;
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

	public List<EnderecoNewDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoNewDTO> enderecos) {
		this.enderecos = enderecos;
	}

	public List<TelefoneNewDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneNewDTO> telefones) {
		this.telefones = telefones;
	}

}
