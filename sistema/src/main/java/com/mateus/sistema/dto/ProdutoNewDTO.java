package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ProdutoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres")
	private String descricao;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String referencia;
	
	public ProdutoNewDTO() {
	}

	public ProdutoNewDTO(String descricao, String referencia) {
		this.descricao = descricao;
		this.referencia = referencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
