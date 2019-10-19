package com.mateus.sistema.dto.pessoa.fornecedor;

import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Fornecedor;
import com.mateus.sistema.dto.pessoa.PessoaDTO;
import com.mateus.sistema.dto.pessoa.endereco.EnderecoDTO;
import com.mateus.sistema.dto.pessoa.telefone.TelefoneDTO;

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
