package com.mateus.sistema.services.pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;

@Service
public class FormaPagamentoPedidoService {

	@Autowired
	private FormaPagamentoService formaPagamentoService;
	@Autowired
	private ParcelaService parcelaService;
	@Autowired
	private ContaReceberService crService;

	public List<FormaPagamentoVenda> fromNewDto(List<FormaPagamentoPedidoNewDTO> list, Venda venda) {

		List<FormaPagamentoVenda> formasPagamento = new ArrayList<FormaPagamentoVenda>();

		for (FormaPagamentoPedidoNewDTO dto : list) {
			FormaPagamentoVenda fpv = fromNewFormaPagamentoPedidoDTO(dto, venda);
			fpv.setParcelas(parcelaService.fromNewDto(dto.getParcelas(), fpv));
			if (dto.getConta() != null ) {
				fpv.setContaReceber(crService.fromNewFormaPagamentoDTO(dto.getConta(), fpv));
			}
			formasPagamento.add(fpv);
		}

		return formasPagamento;
	}
	
	public List<FormaPagamentoCompra> fromNewDto(List<FormaPagamentoPedidoNewDTO> list, Compra venda) {

		List<FormaPagamentoCompra> formasPagamento = new ArrayList<FormaPagamentoCompra>();

		for (FormaPagamentoPedidoNewDTO dto : list) {
			FormaPagamentoCompra fpc = fromNewFormaPagamentoPedidoDTO(dto, venda);
			fpc.setParcelas(parcelaService.fromNewDto(dto.getParcelas(), fpc));
			if (dto.getConta() != null ) {
				fpc.setContaPagar(crService.fromNewFormaPagamentoDTO(dto.getConta(), fpc));
			}
			formasPagamento.add(fpc);
		}

		return formasPagamento;
	}

	public FormaPagamentoVenda fromNewFormaPagamentoPedidoDTO(FormaPagamentoPedidoNewDTO newDTo, Venda venda) {
		return new FormaPagamentoVenda(null, venda, formaPagamentoService.fromDto(newDTo.getFormaPagamento()),
				newDTo.getData(), newDTo.getValor(), newDTo.getEstado());
	}
	
	public FormaPagamentoCompra fromNewFormaPagamentoPedidoDTO(FormaPagamentoPedidoNewDTO newDTo, Compra compra) {
		return new FormaPagamentoCompra(null, compra, formaPagamentoService.fromDto(newDTo.getFormaPagamento()),
				newDTo.getData(), newDTo.getValor(), newDTo.getEstado());
	}
}
