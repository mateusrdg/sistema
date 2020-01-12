package com.mateus.sistema.services.pedido.compra;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.CompraItem;
import com.mateus.sistema.dto.pedido.compra.CompraItemDTO;
import com.mateus.sistema.services.produto.EstoqueService;
import com.mateus.sistema.services.produto.ProdutoService;

@Service
public class CompraItemService {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EstoqueService estoqueService;
	
	public List<CompraItem> fromDTO(List<CompraItemDTO> itens, Compra compra) {
		return itens.stream()
				.map(obj -> new CompraItem(null, compra, produtoService.fromDTO(obj.getProduto()),
						estoqueService.fromDto(obj.getEstoque()), obj.getPreco(),obj.getQuantidade(), obj.getDesconto()))
				.collect(Collectors.toList());
	}

	public void validarItens(List<CompraItem> itens) {
		//TODO	
	}

}
