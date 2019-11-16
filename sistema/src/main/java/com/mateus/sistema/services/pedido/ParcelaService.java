package com.mateus.sistema.services.pedido;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaNewDTO;

@Service
public class ParcelaService {

	@Autowired
	private ContaReceberService crService;
	public List<ParcelaVenda> fromNewDto (List<ParcelaNewDTO> list, FormaPagamentoVenda fpv) {
		List<ParcelaVenda> parcelas = new ArrayList<ParcelaVenda>();
		
		for (ParcelaNewDTO obj : list) {
			ParcelaVenda parcela = new ParcelaVenda(null, fpv, obj.getValor(), obj.getEstado(),
					obj.getDataVencimento(), obj.getDataPagamento());
			parcela.setContaReceber(crService.fromNewParcelaDTO(obj.getConta(), parcela));
			parcelas.add(parcela);
		}
		
		return parcelas;
	}
}
