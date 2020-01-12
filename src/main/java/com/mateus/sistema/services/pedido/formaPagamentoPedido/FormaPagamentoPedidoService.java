package com.mateus.sistema.services.pedido.formaPagamentoPedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.enums.TipoFormaPagamento;
import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.FormaPagamentoIdDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoDTO;
import com.mateus.sistema.services.exceptions.BusinessException;
import com.mateus.sistema.services.pedido.FormaPagamentoService;
import com.mateus.sistema.services.pedido.formaPagamentoPedido.parcela.ParcelaService;

@Service
public class FormaPagamentoPedidoService {

	@Autowired
	private FormaPagamentoService formaPagamentoService;
	@Autowired
	private ParcelaService parcelaService;

	public List<FormaPagamentoVenda> fromDTO(List<FormaPagamentoPedidoDTO> list, Venda venda) {
		List<FormaPagamentoVenda> formasPagamento = new ArrayList<FormaPagamentoVenda>();
		for (FormaPagamentoPedidoDTO dto : list) {
			FormaPagamentoVenda fpv = fromFormaPagamentoPedidoDTO(dto, venda);
			fpv.setParcelas(parcelaService.fromDto(dto.getParcelas(), fpv));
			formasPagamento.add(fpv);
		}
		return formasPagamento;
	}

	public List<FormaPagamentoCompra> fromDTO(List<FormaPagamentoPedidoDTO> list, Compra compra) {
		List<FormaPagamentoCompra> formasPagamento = new ArrayList<FormaPagamentoCompra>();
		for (FormaPagamentoPedidoDTO dto : list) {
			FormaPagamentoCompra fpc = fromFormaPagamentoPedidoDTO(dto, compra);
			fpc.setParcelas(parcelaService.fromDto(dto.getParcelas(), fpc));
			formasPagamento.add(fpc);
		}
		return formasPagamento;
	}

	public FormaPagamentoVenda fromFormaPagamentoPedidoDTO(FormaPagamentoPedidoDTO dto, Venda venda) {
		return new FormaPagamentoVenda(((dto.getId() == null) ? null : dto.getId()), venda,
				formaPagamentoService.fromDTO(dto.getFormaPagamento()), dto.getData(), dto.getValor(),
				getEstadoPagamentoPorFormaPagamento(dto.getFormaPagamento()));
	}

	public FormaPagamentoCompra fromFormaPagamentoPedidoDTO(FormaPagamentoPedidoDTO dto, Compra compra) {
		return new FormaPagamentoCompra(((dto.getId() == null) ? null : dto.getId()), compra,
				formaPagamentoService.fromDTO(dto.getFormaPagamento()), dto.getData(), dto.getValor(),
				getEstadoPagamentoPorFormaPagamento(dto.getFormaPagamento()));
	}

	private EstadoPagamento getEstadoPagamentoPorFormaPagamento(FormaPagamentoIdDTO formaPagamento) {
		TipoFormaPagamento tipo = formaPagamentoService.fromDTO(formaPagamento).getTipo();
		EstadoPagamento estadoPagamento;
		if (tipo == TipoFormaPagamento.AVISTA) {
			estadoPagamento = EstadoPagamento.QUITADO;
		} else {
			estadoPagamento = EstadoPagamento.PENDENTE;
		}
		return estadoPagamento;
	}

	public void validarFormasPagamentoPedido(List<? extends FormaPagamentoPedido> formasPagamentoPedido) {
		for (FormaPagamentoPedido formaPagamentoPedido : formasPagamentoPedido) {

			if (formaPagamentoPedido.getFormaPagamento().getTipo() == TipoFormaPagamento.PRAZO) {
				if (formaPagamentoPedido.getParcelas().isEmpty()) {
					throw new BusinessException("É necessário criar ao menos 1 parcela para forma de pagamento: "
							+ formaPagamentoPedido.getFormaPagamento().getTipo().getDescricao());
				}
				if (!(formaPagamentoPedido.getValor().compareTo(formaPagamentoPedido.getValorTotalParcelas()) == 0)) {
					throw new BusinessException(
							"valor total das parcelas deve ser igual ao valor da forma de pagamento associada");
				} else {
					parcelaService.validaParcelas(formaPagamentoPedido.getParcelas());
				}

			} else {
				if (!formaPagamentoPedido.getParcelas().isEmpty()) {
					throw new BusinessException("forma de pagamento não permite parcelamento");
				}
			}
		}

	}

}
