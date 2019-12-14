package com.mateus.sistema.dto.pessoa.fornecedor;

import java.io.Serializable;
import java.util.List;

import com.mateus.sistema.dto.pessoa.PessoaNewDTO;
import com.mateus.sistema.dto.pessoa.endereco.EnderecoNewDTO;
import com.mateus.sistema.dto.pessoa.telefone.TelefoneNewDTO;

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
