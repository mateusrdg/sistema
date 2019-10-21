package com.mateus.sistema.dto.formaPagamento;

import com.mateus.sistema.domain.FormaPagamento;
import com.mateus.sistema.domain.enums.TipoFormaPagamento;

public class FormaPagamentoDTO {

	private Long id;
	private String descricao;
	private TipoFormaPagamento tipo;

	public FormaPagamentoDTO() {
		
	}

	public FormaPagamentoDTO(FormaPagamento formaPagamento) {
		this.id = formaPagamento.getId();
		this.descricao = formaPagamento.getDescricao();
		this.tipo = TipoFormaPagamento.toEnum(formaPagamento.getTipo());
	}
	
	public FormaPagamentoDTO(Long id, String descricao, TipoFormaPagamento tipo) {
		this.id = id;
		this.descricao = descricao;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TipoFormaPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoFormaPagamento tipo) {
		this.tipo = tipo;
	}

}
