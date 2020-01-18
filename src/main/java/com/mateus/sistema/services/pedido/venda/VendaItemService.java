package com.mateus.sistema.services.pedido.venda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.PedidoItem;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.pedido.venda.VendaItemDTO;
import com.mateus.sistema.repository.pedido.VendaItemRepository;
import com.mateus.sistema.repository.produto.ProdutoEstoqueRepository;
import com.mateus.sistema.services.exceptions.BusinessException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;
import com.mateus.sistema.services.produto.EstoqueService;
import com.mateus.sistema.services.produto.PrecoService;
import com.mateus.sistema.services.produto.ProdutoService;
import com.mateus.sistema.services.produto.EstoqueService.Operacao;

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
	@Autowired
	private VendaItemRepository repo;

	public List<VendaItem> fromDTO(List<VendaItemDTO> itens, Venda venda) {
		return itens.stream()
				.map(obj -> new VendaItem(((obj.getId() == null) ? null : obj.getId()), venda,
						produtoService.fromDTO(obj.getProduto()), estoqueService.fromDto(obj.getEstoque()),
						precoService.getValorByTipoPrecoAndProduto(obj.getTipoPreco().getCod(),
								obj.getProduto().getId()),
						obj.getQuantidade(), obj.getDesconto()))
				.collect(Collectors.toList());

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

	public void updateItens(Venda obj, List<VendaItem> listaNovos) {
		// List<VendaItem> itens = repo.findByPedido(obj);
		for (int i = obj.getItens().size() -1 ; i >= 0 ; i--) {
			VendaItem item = obj.getItens().get(i);
			if (listaNovos.stream().map(x -> x.getId() == item.getId()).collect(Collectors.toList()).contains(true)) {
				obj.getItens().remove(i);
			}
			estoqueService.atualizaEstoque(Arrays.asList(item), Operacao.ACRESCENTAR);
			i--;
		}
		
	}
}
