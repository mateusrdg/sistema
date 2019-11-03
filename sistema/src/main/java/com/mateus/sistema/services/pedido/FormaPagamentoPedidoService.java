package com.mateus.sistema.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.FormaPagamentoVenda;
import com.mateus.sistema.domain.Venda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;

@Service
public class FormaPagamentoPedidoService {

	@Autowired
	private FormaPagamentoService formaPagamentoService;
	@Autowired
	private ParcelaService parcelaService;
	
	public List<FormaPagamentoVenda> fromDto(List<FormaPagamentoPedidoNewDTO> list, Venda venda) {
		
		List<FormaPagamentoVenda> formasPagamento = new ArrayList<FormaPagamentoVenda>();
		
		for (FormaPagamentoPedidoNewDTO dto : list) {
			FormaPagamentoVenda fpv = new FormaPagamentoVenda(null, venda,
					formaPagamentoService.fromDto(dto.getFormaPagamento()), dto.getData(), dto.getValor(), dto.getEstado());
			fpv.setParcelas(parcelaService.fromDto(dto.getParcelas(), fpv));
			formasPagamento.add(fpv);
		}
		
		return formasPagamento;
	}
}
