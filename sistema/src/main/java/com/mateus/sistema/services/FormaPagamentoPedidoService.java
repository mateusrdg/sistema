package com.mateus.sistema.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.FormaPagamentoVenda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;

@Service
public class FormaPagamentoPedidoService {

	@Autowired
	private FormaPagamentoService formaPagamentoService;

	public List<FormaPagamentoVenda> fromDto(List<FormaPagamentoPedidoNewDTO> list) {
		return list.stream().map(obj -> new FormaPagamentoVenda(null, null,
				formaPagamentoService.fromDto(obj.getFormaPagamento()), obj.getData(), obj.getValor(), obj.getEstado()))
				.collect(Collectors.toList());
	}
}
