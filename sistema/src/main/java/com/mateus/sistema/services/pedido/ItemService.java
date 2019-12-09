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
import com.mateus.sistema.dto.pedido.item.CompraItemNewDTO;
import com.mateus.sistema.dto.pedido.item.VendaItemNewDTO;
import com.mateus.sistema.services.produto.EstoqueService;
import com.mateus.sistema.services.produto.PrecoService;
import com.mateus.sistema.services.produto.ProdutoService;

@Service
public class ItemService {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private PrecoService precoService;

	public List<VendaItem> fromDTO(List<VendaItemNewDTO> itens, Venda venda) {
		return itens.stream().map(obj -> new VendaItem(null, venda, produtoService.fromDto(obj.getProduto()),
				estoqueService.fromDto(obj.getEstoque()), precoService.valorFromDTO(obj.getTipoPreco(), obj.getProduto()),
				obj.getQuantidade(), obj.getDesconto())).collect(Collectors.toList());
	}

	public List<CompraItem> fromDTO(List<CompraItemNewDTO> itens, Compra compra) {
		return itens.stream()
				.map(obj -> new CompraItem(null, compra, produtoService.fromDto(obj.getProduto()),
						estoqueService.fromDto(obj.getEstoque()), obj.getPreco(),obj.getQuantidade(), obj.getDesconto()))
				.collect(Collectors.toList());
	}

	public List<OrcamentoItem> fromDTO(List<VendaItemNewDTO> itens, Orcamento orcamento) {
		return itens.stream().map(obj -> new OrcamentoItem(null, orcamento, produtoService.fromDto(obj.getProduto()),
				estoqueService.fromDto(obj.getEstoque()), precoService.valorFromDTO(obj.getTipoPreco(), obj.getProduto()),
				obj.getQuantidade(), obj.getDesconto())).collect(Collectors.toList());
	}
}
