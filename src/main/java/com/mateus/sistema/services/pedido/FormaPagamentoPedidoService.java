package com.mateus.sistema.services.pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.enums.TipoFormaPagamento;
import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.services.exceptions.BusinessException;

@Service
public class FormaPagamentoPedidoService {

	@Autowired
	private FormaPagamentoService formaPagamentoService;
	@Autowired
	private ParcelaService parcelaService;

	public List<FormaPagamentoVenda> fromNewDto(List<FormaPagamentoPedidoNewDTO> list, Venda venda) {

		List<FormaPagamentoVenda> formasPagamento = new ArrayList<FormaPagamentoVenda>();

		for (FormaPagamentoPedidoNewDTO dto : list) {
			FormaPagamentoVenda fpv = fromNewFormaPagamentoPedidoDTO(dto, venda);
			fpv.setParcelas(parcelaService.fromNewDto(dto.getParcelas(), fpv));
			formasPagamento.add(fpv);
		}

		return formasPagamento;
	}

	public List<FormaPagamentoCompra> fromNewDto(List<FormaPagamentoPedidoNewDTO> list, Compra venda) {

		List<FormaPagamentoCompra> formasPagamento = new ArrayList<FormaPagamentoCompra>();

		for (FormaPagamentoPedidoNewDTO dto : list) {
			FormaPagamentoCompra fpc = fromNewFormaPagamentoPedidoDTO(dto, venda);
			fpc.setParcelas(parcelaService.fromNewDto(dto.getParcelas(), fpc));
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

	public void validarFormasPagamentoPedido(List<? extends FormaPagamentoPedido> formasPagamentoPedido) {
		
		if (formasPagamentoPedido instanceof FormaPagamentoVenda) {
			@SuppressWarnings("unchecked")
			List<FormaPagamentoVenda> formasPagamentoVenda = (List<FormaPagamentoVenda>) formasPagamentoPedido;
			for (FormaPagamentoVenda formaPagamentoVenda : formasPagamentoVenda) {

				if (formaPagamentoVenda.getFormaPagamento().getTipo() == TipoFormaPagamento.PRAZO) {
					if (!(formaPagamentoVenda.getValor().compareTo(formaPagamentoVenda.getValorTotalParcelas()) == 0)) {
						throw new BusinessException(
								"valor total das parcelas deve ser igual ao valor da forma de pagamento associada");
					} else {
						parcelaService.validaParcelas(formaPagamentoVenda.getParcelas());
					}

				} else {
					if (!formaPagamentoVenda.getParcelas().isEmpty()) {
						throw new BusinessException("forma de pagamento não permite parcelamento");
					}
					if (!(formaPagamentoVenda.getValor()
							.compareTo(formaPagamentoVenda.getContaReceber().getValor()) == 0)) {
						throw new BusinessException("valor da forma de pagamento difere do valor do conta a receber");
					}
				}
			}
		} else if (formasPagamentoPedido instanceof FormaPagamentoCompra) {
			@SuppressWarnings("unchecked")
			List<FormaPagamentoCompra> formasPagamentoCompra = (List<FormaPagamentoCompra>) formasPagamentoPedido;
			for (FormaPagamentoCompra formaPagamentoCompra : formasPagamentoCompra) {

				if (formaPagamentoCompra.getFormaPagamento().getTipo() == TipoFormaPagamento.PRAZO) {
					if (!(formaPagamentoCompra.getValor().compareTo(formaPagamentoCompra.getValorTotalParcelas()) == 0)) {
						throw new BusinessException(
								"valor total das parcelas deve ser igual ao valor da forma de pagamento associada");
					} else {
						parcelaService.validaParcelas(formaPagamentoCompra.getParcelas());
					}

				} else {
					if (!formaPagamentoCompra.getParcelas().isEmpty()) {
						throw new BusinessException("forma de pagamento não permite parcelamento");
					}
					if (!(formaPagamentoCompra.getValor()
							.compareTo(formaPagamentoCompra.getContaPagar().getValor()) == 0)) {
						throw new BusinessException("valor da forma de pagamento difere do valor do conta a pagar");
					}
				}
			}
		}
		
		

	}
}
