package com.mateus.sistema.dto.pedido;

import com.mateus.sistema.domain.enums.TipoFormaPagamento;
import com.mateus.sistema.domain.pedido.FormaPagamento;

public class FormaPagamentoDTO extends FormaPagamentoIdDTO{
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private TipoFormaPagamento tipo;

	public FormaPagamentoDTO() {
		
	}

	public FormaPagamentoDTO(FormaPagamento formaPagamento) {
		super(formaPagamento);
		this.descricao = formaPagamento.getDescricao();
		this.tipo = formaPagamento.getTipo();
	}
	
	public FormaPagamentoDTO(Long id, String descricao, TipoFormaPagamento tipo) {
		setId(id);
		this.descricao = descricao;
		this.tipo = tipo;
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
