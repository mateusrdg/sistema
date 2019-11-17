package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.CompraItem;
import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.domain.pedido.OrcamentoItem;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;
import com.mateus.sistema.dto.pedido.item.PedidoItemNewDTO;
import com.mateus.sistema.services.produto.ProdutoService;

@Service
public class ItemService {

	@Autowired
	private ProdutoService produtoService;

	public List<VendaItem> fromDTO(List<PedidoItemNewDTO> itens, Venda venda) {
		return itens.stream().map(obj -> new VendaItem(null, venda, produtoService.fromDto(obj.getProduto()),
				obj.getQuantidade(), obj.getPreco(), obj.getDesconto())).collect(Collectors.toList());
	}

	public List<CompraItem> fromDTO(List<PedidoItemNewDTO> itens, Compra compra) {
		return itens.stream().map(obj -> new CompraItem(null, compra, produtoService.fromDto(obj.getProduto()),
				obj.getQuantidade(), obj.getPreco(), obj.getDesconto())).collect(Collectors.toList());
	}
	
	public List<OrcamentoItem> fromDTO(List<PedidoItemNewDTO> itens, Orcamento orcamento) {
		return itens.stream().map(obj -> new OrcamentoItem(null, orcamento, produtoService.fromDto(obj.getProduto()),
				obj.getQuantidade(), obj.getPreco(), obj.getDesconto())).collect(Collectors.toList());
	}
}
