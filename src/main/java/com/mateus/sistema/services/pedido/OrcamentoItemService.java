package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.domain.pedido.OrcamentoItem;
import com.mateus.sistema.dto.pedido.item.VendaItemDTO;
import com.mateus.sistema.services.produto.EstoqueService;
import com.mateus.sistema.services.produto.PrecoService;
import com.mateus.sistema.services.produto.ProdutoService;

@Service
public class OrcamentoItemService {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private PrecoService precoService;
	
	public List<OrcamentoItem> fromNewDTO(List<VendaItemDTO> itens, Orcamento orcamento) {
		return itens.stream()
				.map(obj -> new OrcamentoItem(null, orcamento, produtoService.fromDTO(obj.getProduto()),
						estoqueService.fromDto(obj.getEstoque()),
						precoService.getValorByTipoPrecoAndProduto(obj.getTipoPreco().getCod(),
								obj.getProduto().getId()),
						obj.getQuantidade(), obj.getDesconto()))
				.collect(Collectors.toList());
	}

}
