package com.mateus.sistema.services.pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.ParcelaCompra;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaNewDTO;
import com.mateus.sistema.services.exceptions.BusinessException;

@Service
public class ParcelaService {

	@Autowired
	private ContaReceberService crService;

	public List<ParcelaVenda> fromNewDto(List<ParcelaNewDTO> list, FormaPagamentoVenda fpp) {
		List<ParcelaVenda> parcelas = new ArrayList<ParcelaVenda>();

		for (ParcelaNewDTO obj : list) {
			ParcelaVenda parcela = new ParcelaVenda(null, fpp, obj.getValor(), obj.getEstado(), obj.getDataVencimento(),
					obj.getDataPagamento());
			parcela.setContaReceber(crService.fromNewParcelaDTO(obj.getConta(), parcela));
			parcelas.add(parcela);
		}

		return parcelas;
	}

	public List<ParcelaCompra> fromNewDto(List<ParcelaNewDTO> list, FormaPagamentoCompra fpp) {
		List<ParcelaCompra> parcelas = new ArrayList<ParcelaCompra>();

		for (ParcelaNewDTO obj : list) {
			ParcelaCompra parcela = new ParcelaCompra(null, fpp, obj.getValor(), obj.getEstado(),
					obj.getDataVencimento(), obj.getDataPagamento());
			parcela.setContaPagar((crService.fromNewParcelaDTO(obj.getConta(), parcela)));
			parcelas.add(parcela);
		}

		return parcelas;
	}

	public void validaParcelas(List<ParcelaVenda> parcelas) {
		for (ParcelaVenda parcela : parcelas) {
//			if (parcela.getContaReceber() == null) {
//				throw new BusinessException("conta a receber não foi criada");
//			}
			if (!(parcela.getValor().compareTo(parcela.getContaReceber().getValor()) == 0)) {
				throw new BusinessException("valor da parcela difere do valor do conta a receber");
			}
		}
	}
}
