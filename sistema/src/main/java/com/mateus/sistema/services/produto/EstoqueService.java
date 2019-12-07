package com.mateus.sistema.services.produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.CompraItem;
import com.mateus.sistema.domain.pedido.EntradaEstoque;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;
import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.produto.estoque.EstoqueIdDTO;
import com.mateus.sistema.dto.produto.estoque.ProdutoEstoqueDTO;
import com.mateus.sistema.repository.pedido.EntradaEstoqueRepository;
import com.mateus.sistema.repository.produto.EstoqueRepository;
import com.mateus.sistema.repository.produto.ProdutoEstoqueRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class EstoqueService {
	@Autowired
	private EstoqueRepository repo;
	@Autowired
	private EntradaEstoqueRepository entradaEstoqueRepo;
	@Autowired
	private ProdutoEstoqueRepository prodEstRepo;

	public Estoque find(Long id) {
		Optional<Estoque> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Estoque não encontrado! Id: " + id + ", Tipo: " + Estoque.class.getName()));
	}
	
	public List<ProdutoEstoque> fromNewDto(List<EstoqueIdDTO> estoques, Produto obj) {
		return estoques.stream().map(x -> new ProdutoEstoque(null, new Estoque(x.getId()), obj, null))
				.collect(Collectors.toList());
	}

	public List<ProdutoEstoque> fromDto(List<ProdutoEstoqueDTO> estoques, Produto obj) {
		return estoques.stream()
				.map(x -> new ProdutoEstoque(x.getId(), new Estoque(x.getEstoque().getId()), obj, x.getQuantidade()))
				.collect(Collectors.toList());
	}
	
	public Estoque fromDto (EstoqueIdDTO objDto) {
		return find(objDto.getId());
	}

	public void geraEntradas(List<CompraItem> itens) {
		List<EntradaEstoque> entradas = getEntradas(itens);
		entradaEstoqueRepo.saveAll(entradas);
		atualizaEstoque(entradas);
	}

	private List<EntradaEstoque> getEntradas(List<CompraItem> itens) {
		List<EntradaEstoque> entradas = new ArrayList<>();
		entradas.addAll(itens.stream().map(x -> new EntradaEstoque(null, x, repo.getOne((long) 2)))
				.collect(Collectors.toList()));
		return entradas;
	}

	private void atualizaEstoque(List<EntradaEstoque> entradas) {
		List<ProdutoEstoque> list = new ArrayList<ProdutoEstoque>();
		for (EntradaEstoque entrada : entradas) {
			Optional<ProdutoEstoque> peo = prodEstRepo.findByProdutoAndEstoque(entrada.getItem().getProduto(),
					entrada.getEstoque());
			if (peo.isPresent()) {
				ProdutoEstoque pe = peo.get();
				pe.setQuantidade(entrada.getQuantidade().add(pe.getQuantidade()));
				list.add(pe);
			} else {
				list.add(new ProdutoEstoque(null, entrada.getEstoque(), entrada.getItem().getProduto(),
						entrada.getQuantidade()));
			}
		}

		prodEstRepo.saveAll(list);
	}

	public void atualizaEstoque(Venda obj) {
		List<ProdutoEstoque> list = new ArrayList<ProdutoEstoque>();
		for (VendaItem item : obj.getItens()) {
			Optional<ProdutoEstoque> peo = prodEstRepo.findByProdutoAndEstoque(item.getProduto(),item.getEstoque());
			if (peo.isPresent()) {
				ProdutoEstoque pe = peo.get();
				pe.setQuantidade(pe.getQuantidade().subtract(item.getQuantidade()));
				list.add(pe);
			} else {
				throw new ObjectNotFoundException("Produto não possui estoque associado!");
			}
		}

		prodEstRepo.saveAll(list);

	}

}
