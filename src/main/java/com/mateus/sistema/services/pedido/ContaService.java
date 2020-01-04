package com.mateus.sistema.services.pedido;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.enums.TipoFormaPagamento;
import com.mateus.sistema.domain.pedido.ContaPagar;
import com.mateus.sistema.domain.pedido.ContaReceber;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.Parcela;
import com.mateus.sistema.domain.pedido.ParcelaCompra;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.ContaNewDTO;

@Service
public class ContaService {

	public ContaReceber fromNewFormaPagamentoDTO(ContaNewDTO conta, FormaPagamentoVenda fpp) {
		return new ContaReceber(null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(),
				conta.getDataVencimento(), fpp, null);
	}

	public ContaPagar fromNewFormaPagamentoDTO(ContaNewDTO conta, FormaPagamentoCompra fpp) {
		return new ContaPagar(null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(),
				conta.getDataVencimento(), fpp, null);
	}

	public ContaReceber fromNewParcelaDTO(ContaNewDTO conta, ParcelaVenda obj) {
		return new ContaReceber(null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(),
				conta.getDataVencimento(), null, obj);
	}

	public ContaPagar fromNewParcelaDTO(ContaNewDTO conta, ParcelaCompra obj) {
		return new ContaPagar(null, conta.getValor(), conta.getEstado(), conta.getDataPagamento(),
				conta.getDataVencimento(), null, obj);
	}
	public void geraContas(List<? extends FormaPagamentoPedido> formasPagamento) {
		for (FormaPagamentoPedido formaPagamentoPedido : formasPagamento) {
			geraContasPorTipoFormaDePagamento(formaPagamentoPedido);
		}

	}

	private void geraContasPorTipoFormaDePagamento(FormaPagamentoPedido formaPagamentoPedido) {

		if (formaPagamentoPedido instanceof FormaPagamentoVenda) {
			FormaPagamentoVenda formaPagamentoVenda = (FormaPagamentoVenda) formaPagamentoPedido;

			if (formaPagamentoVenda.getFormaPagamento().getTipo() == TipoFormaPagamento.PRAZO
					|| formaPagamentoVenda.getFormaPagamento().getTipo() == TipoFormaPagamento.CARTAO) {
				Calendar data = Calendar.getInstance();
				for (Parcela parcela : formaPagamentoVenda.getParcelas()) {
					data.add(Calendar.MONTH, 1);
					((ParcelaVenda)parcela).setContaReceber(new ContaReceber(null, parcela.getValor(), EstadoPagamento.PENDENTE, null,
							data, null, ((ParcelaVenda)parcela)));
				}
			} else if (formaPagamentoVenda.getFormaPagamento().getTipo() == TipoFormaPagamento.AVISTA) {
				(formaPagamentoVenda).setConta(
						new ContaReceber(null, formaPagamentoPedido.getValor(), EstadoPagamento.QUITADO,
								Calendar.getInstance(), Calendar.getInstance(), formaPagamentoVenda, null));
			}
		} else if (formaPagamentoPedido instanceof FormaPagamentoCompra) {
			FormaPagamentoCompra formaPagamentoCompra = (FormaPagamentoCompra) formaPagamentoPedido;

			if (formaPagamentoCompra.getFormaPagamento().getTipo() == TipoFormaPagamento.PRAZO
					|| formaPagamentoCompra.getFormaPagamento().getTipo() == TipoFormaPagamento.CARTAO) {
				Calendar data = Calendar.getInstance();
				for (Parcela parcela : formaPagamentoCompra.getParcelas()) {
					data.add(Calendar.MONTH, 1);
					((ParcelaCompra) parcela).setContaPagar(new ContaPagar(null, parcela.getValor(), EstadoPagamento.PENDENTE, null, data,
							null, (ParcelaCompra)parcela));
				}
			} else if (formaPagamentoCompra.getFormaPagamento().getTipo() == TipoFormaPagamento.AVISTA) {
				(formaPagamentoCompra)
						.setContaPagar(new ContaPagar(null, formaPagamentoPedido.getValor(), EstadoPagamento.QUITADO,
								Calendar.getInstance(), Calendar.getInstance(), formaPagamentoCompra, null));
			}
		}
		
	
	}

}
