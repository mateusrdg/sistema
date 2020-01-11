package com.mateus.sistema.services.pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.Parcela;
import com.mateus.sistema.domain.pedido.ParcelaCompra;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaDTO;
import com.mateus.sistema.services.exceptions.BusinessException;

@Service
public class ParcelaService {

	public List<ParcelaVenda> fromDto(List<ParcelaDTO> list, FormaPagamentoVenda fpv) {
		List<ParcelaVenda> parcelas = new ArrayList<ParcelaVenda>();
		for (ParcelaDTO obj : list) {
			ParcelaVenda parcela = new ParcelaVenda(((obj.getId() == null) ? null : obj.getId()), fpv, obj.getValor(),
					obj.getEstado(), obj.getDataVencimento(), obj.getDataPagamento());
			parcelas.add(parcela);
		}
		return parcelas;
	}

	public List<ParcelaCompra> fromDto(List<ParcelaDTO> list, FormaPagamentoCompra fpc) {
		List<ParcelaCompra> parcelas = new ArrayList<ParcelaCompra>();
		for (ParcelaDTO obj : list) {
			ParcelaCompra parcela = new ParcelaCompra(((obj.getId() == null) ? null : obj.getId()), fpc, obj.getValor(),
					obj.getEstado(), obj.getDataVencimento(), obj.getDataPagamento());
			parcelas.add(parcela);
		}
		return parcelas;
	}

	public void validaParcelas(List<? extends Parcela> parcelas) {
		if (parcelas instanceof ParcelaVenda) {
			@SuppressWarnings("unchecked")
			List<ParcelaVenda> parcelasVenda = (List<ParcelaVenda>) parcelas;
			for (ParcelaVenda parcela : parcelasVenda) {
				if (!(parcela.getValor().compareTo(parcela.getContaReceber().getValor()) == 0)) {
					throw new BusinessException("valor da parcela difere do valor do conta a receber");
				}
			}
		} else if (parcelas instanceof ParcelaCompra) {
			@SuppressWarnings("unchecked")
			List<ParcelaCompra> parcelasCompra = (List<ParcelaCompra>) parcelas;
			for (ParcelaCompra parcela : parcelasCompra) {
				if (!(parcela.getValor().compareTo(parcela.getContaPagar().getValor()) == 0)) {
					throw new BusinessException("valor da parcela difere do valor do conta a pagar");
				}
			}
		}

	}

}
