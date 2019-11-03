package com.mateus.sistema.services.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.produto.estoque.EstoqueIdDTO;
@Service
public class EstoqueService {

	public List<ProdutoEstoque> fromDto(List<EstoqueIdDTO> estoques, Produto obj) {
		return estoques.stream().map(x -> new ProdutoEstoque(null, new Estoque(x.getId()), obj)).collect(Collectors.toList());
	}
	
}
