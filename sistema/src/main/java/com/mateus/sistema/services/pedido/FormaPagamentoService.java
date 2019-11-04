package com.mateus.sistema.services.pedido;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.FormaPagamento;
import com.mateus.sistema.dto.pedido.FormaPagamentoDTO;

@Service
public class FormaPagamentoService {

	public FormaPagamento fromDto (FormaPagamentoDTO objDto) {
		return new FormaPagamento(objDto.getId(), objDto.getDescricao(), objDto.getTipo());
	}
}