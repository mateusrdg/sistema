package com.mateus.sistema.dto.pessoa.fornecedor;

import com.mateus.sistema.domain.pessoa.Fornecedor;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class FornecedorDTO extends PessoaDTO {

	private String nomeFantasia;

	public FornecedorDTO() {
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
