package com.mateus.sistema.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Venda;
import com.mateus.sistema.domain.VendaItem;
import com.mateus.sistema.dto.pedido.item.PedidoItemNewDTO;

@Service
public class ItemService {

	@Autowired
	private ProdutoService produtoService;
	
	public List<VendaItem> fromDTO(List<PedidoItemNewDTO> itens, Venda venda) {

		return itens.stream().map(obj -> new VendaItem(null, venda, produtoService.fromDto(obj.getProduto()),
				obj.getQuantidade(), obj.getPreco(), obj.getDesconto())).collect(Collectors.toList());
	}
}
