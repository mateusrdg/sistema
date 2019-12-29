package com.mateus.sistema.services.validation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.repository.produto.ProdutoEstoqueRepository;
import com.mateus.sistema.services.exceptions.BusinessException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class VendaValidator {
	@Autowired
	private ProdutoEstoqueRepository peRepo;

	public void isValid(Venda venda) {
		for (VendaItem item : venda.getItens()) {

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
