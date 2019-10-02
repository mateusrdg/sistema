package com.mateus.sistema.dto;

import java.util.Calendar;

import com.mateus.sistema.domain.Pessoa;

public class PessoaDTO {

	private Long id;
	private String nome;
	private String email;
	private String cpfCnpj;
	private Calendar dataCadastro;
	private Boolean ativo;
	
	public PessoaDTO() {
	}

	public PessoaDTO(Long id, String nome, String email, String cpfCnpj, Calendar dataCadastro, Boolean ativo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.dataCadastro = dataCadastro;
		this.setAtivo(ativo);
	}

	public PessoaDTO(Pessoa pessoa) {
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.cpfCnpj = pessoa.getCpfCnpj();
		this.dataCadastro = pessoa.getDataCadastro();
		this.setAtivo(pessoa.getAtivo());
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
}
