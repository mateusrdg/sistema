package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.List;

public class FornecedorNewDTO extends PessoaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomeFantasia;

	public FornecedorNewDTO() {
		super();
	}

	public FornecedorNewDTO(String nome, String email, String cpfCnpj, List<EnderecoNewDTO> enderecos,
			List<TelefoneNewDTO> telefones, String nomeFantasia) {
		super(nome, email, cpfCnpj, enderecos, telefones);
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
