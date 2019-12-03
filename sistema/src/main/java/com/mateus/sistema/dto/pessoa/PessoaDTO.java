package com.mateus.sistema.dto.pessoa;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.sistema.domain.pessoa.Pessoa;
import com.mateus.sistema.dto.pessoa.endereco.EnderecoDTO;
import com.mateus.sistema.dto.pessoa.telefone.TelefoneDTO;

public class PessoaDTO extends PessoaIdDTO{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String cpfCnpj;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar dataCadastro;
	private Boolean ativo;

	private List<EnderecoDTO> enderecos = new ArrayList<EnderecoDTO>();
	private List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();

	public PessoaDTO() {
	}

	public PessoaDTO(Pessoa pessoa) {
		super(pessoa);
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.cpfCnpj = pessoa.getCpfCnpj();
		this.dataCadastro = pessoa.getDataCadastro();
		this.setAtivo(pessoa.getAtivo());
		this.enderecos = pessoa.getEnderecos().stream().map(obj -> new EnderecoDTO()).collect(Collectors.toList());
		this.telefones = pessoa.getTelefones().stream().map(obj -> new TelefoneDTO()).collect(Collectors.toList());
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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<EnderecoDTO> enderecos) {
		this.enderecos = enderecos;
	}

	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}
}
