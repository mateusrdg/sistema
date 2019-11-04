package com.mateus.sistema.services.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.produto.estoque.EstoqueIdDTO;
import com.mateus.sistema.dto.produto.estoque.ProdutoEstoqueDTO;
@Service
public class EstoqueService {

	public List<ProdutoEstoque> fromNewDto(List<EstoqueIdDTO> estoques, Produto obj) {
		return estoques.stream().map(x -> new ProdutoEstoque(null, new Estoque(x.getId()), obj, null)).collect(Collectors.toList());
	}

	public List<ProdutoEstoque> fromDto(List<ProdutoEstoqueDTO> estoques, Produto obj) {
		List <ProdutoEstoque> list = estoques.stream().map(x -> new ProdutoEstoque(x.getId(), new Estoque(x.getEstoque().getId()), obj, x.getQuantidade())).collect(Collectors.toList());
		
		return list;
	}
	
}
