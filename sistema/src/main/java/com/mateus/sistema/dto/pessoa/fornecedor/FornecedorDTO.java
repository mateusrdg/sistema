package com.mateus.sistema.dto;

import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Fornecedor;

public class FornecedorDTO extends PessoaDTO {

	private String nomeFantasia;

	public FornecedorDTO() {
	}

	public FornecedorDTO(Long id, String nome, String nomeFantasia, String email, Calendar dataCadastro, String cpfCnpj,
			Boolean ativo, List<EnderecoDTO> enderecos, List<TelefoneDTO> telefones) {
		super(id, nome, email, cpfCnpj, dataCadastro, ativo, enderecos, telefones);
		this.nomeFantasia = nomeFantasia;
	}

	public FornecedorDTO(Fornecedor Fornecedor) {
		super(Fornecedor);
		this.nomeFantasia = Fornecedor.getNomeFantasia();
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

}
