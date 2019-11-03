package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaNewDTO;

@Service
public class ParcelaService {

	public List<ParcelaVenda> fromDto (List<ParcelaNewDTO> list, FormaPagamentoVenda fpv) {
		return list.stream().map(obj -> new ParcelaVenda(null, fpv, obj.getValor(), obj.getEstado(),
				obj.getDataVencimento(), obj.getDataPagamento())).collect(Collectors.toList());
	}
}
