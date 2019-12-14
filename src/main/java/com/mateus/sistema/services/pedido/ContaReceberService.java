package com.mateus.sistema.services.pedido;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.ContaPagar;
import com.mateus.sistema.domain.pedido.ContaReceber;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.ParcelaCompra;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.ContaNewDTO;

@Service
public class ContaReceberService {

	public ContaReceber fromNewFormaPagamentoDTO(ContaNewDTO conta, FormaPagamentoVenda fpp) {
		return new ContaReceber(null, null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(), conta.getDataVencimento(), fpp, null);
	}

	public ContaPagar fromNewFormaPagamentoDTO(ContaNewDTO conta, FormaPagamentoCompra fpp) {
		return new ContaPagar(null, null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(), conta.getDataVencimento(), fpp, null);
	}
	
	public ContaReceber fromNewParcelaDTO(ContaNewDTO conta, ParcelaVenda obj) {
		return new ContaReceber(null, null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(), conta.getDataVencimento(), null, obj);
	}
	
	public ContaPagar fromNewParcelaDTO(ContaNewDTO conta, ParcelaCompra obj) {
		return new ContaPagar(null, null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(), conta.getDataVencimento(), null, obj);
	}
}
