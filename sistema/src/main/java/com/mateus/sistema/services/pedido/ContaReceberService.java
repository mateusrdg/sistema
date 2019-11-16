package com.mateus.sistema.services.pedido;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.ContaReceber;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.ContaNewDTO;

@Service
public class ContaReceberService {
	public ContaReceber fromNewFormaPagamentoDTO(ContaNewDTO conta, FormaPagamentoVenda fpv) {
		return new ContaReceber(null, null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(), conta.getDataVencimento(), fpv, null);
	}

	public ContaReceber fromNewParcelaDTO(ContaNewDTO conta, ParcelaVenda obj) {
		return new ContaReceber(null, null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(), conta.getDataVencimento(), null, obj);
	}

}
