package com.mateus.sistema.dto.pessoa.endereco;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mateus.sistema.domain.Cidade;

public class EnderecoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres")
	private String rua;
	private String numero;
	private String cep;
	private String complemento;
	private String bairro;
	private Cidade cidade;

	public EnderecoNewDTO() {
	}

	public EnderecoNewDTO(String rua, String numero, String cep, String complemento, String bairro, Cidade cidade) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

}
