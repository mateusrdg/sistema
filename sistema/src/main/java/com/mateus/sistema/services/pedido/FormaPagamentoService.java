package com.mateus.sistema.services;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.FormaPagamento;
import com.mateus.sistema.dto.formaPagamento.FormaPagamentoDTO;

@Service
public class FormaPagamentoService {

	public FormaPagamento fromDto (FormaPagamentoDTO objDto) {
		return new FormaPagamento(objDto.getId(), objDto.getDescricao(), objDto.getTipo());
	}
}
