package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.domain.pedido.OrcamentoItem;
import com.mateus.sistema.domain.pedido.PedidoItem;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.pedido.item.VendaItemNewDTO;
import com.mateus.sistema.repository.produto.ProdutoEstoqueRepository;
import com.mateus.sistema.services.exceptions.BusinessException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;
import com.mateus.sistema.services.produto.EstoqueService;
import com.mateus.sistema.services.produto.PrecoService;
import com.mateus.sistema.services.produto.ProdutoService;

@Service
public class VendaItemService {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private PrecoService precoService;
	@Autowired
	private ProdutoEstoqueRepository peRepo;

	public List<VendaItem> fromDTO(List<VendaItemNewDTO> itens, Venda venda) {
		return itens.stream().map(obj -> new VendaItem(null, venda, produtoService.fromDto(obj.getProduto()),
				estoqueService.fromDto(obj.getEstoque()), precoService.valorFromDTO(obj),
				obj.getQuantidade(), obj.getDesconto())).collect(Collectors.toList());
	}

	public List<OrcamentoItem> fromDTO(List<VendaItemNewDTO> itens, Orcamento orcamento) {
		return itens.stream().map(obj -> new OrcamentoItem(null, orcamento, produtoService.fromDto(obj.getProduto()),
				estoqueService.fromDto(obj.getEstoque()), precoService.valorFromDTO(obj),
				obj.getQuantidade(), obj.getDesconto())).collect(Collectors.toList());
	}

	public void validarItens(List<? extends PedidoItem> itens) {
		for (PedidoItem item : itens) {

			Optional<ProdutoEstoque> pe = peRepo.findByProdutoAndEstoque(item.getProduto(), item.getEstoque());
			if (!pe.isPresent()) {
				throw new ObjectNotFoundException("Não existe relação entra poduto e estoque informados! Produto:"
						+ item.getProduto().getId() + " Estoque: " + item.getEstoque().getId());
			} else {
				ProdutoEstoque produtoEstoque = pe.get();
				if (item.getQuantidade().compareTo(produtoEstoque.getQuantidade()) == 1) {
					throw new BusinessException("Quantidade de estoque insuficiente! Produto:"
							+ item.getProduto().getId() + " Quantidade: " + item.getQuantidade() + " Qtd disponivel em "
							+ produtoEstoque.getEstoque().getDescricao() + ": " + produtoEstoque.getQuantidade());
				}
			}

		}
		
	}

}
