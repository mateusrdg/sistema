package com.mateus.sistema.dto.pedido;

import com.mateus.sistema.domain.pedido.FormaPagamento;
import com.mateus.sistema.dto.EntidadeId;

public class FormaPagamentoIdDTO extends EntidadeId {
	private static final long serialVersionUID = 1L;

	public FormaPagamentoIdDTO() {
	}	
	
	public FormaPagamentoIdDTO(FormaPagamento formaPagamento) {
		super(formaPagamento.getId());
	}	

}
