package com.mateus.sistema.services.produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Preco;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.dto.produto.ProdutoIdDTO;
import com.mateus.sistema.dto.produto.preco.PrecoDTO;
import com.mateus.sistema.dto.produto.preco.PrecoNewDTO;
import com.mateus.sistema.dto.produto.preco.PrecoTipoDTO;
import com.mateus.sistema.repository.produto.PrecoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class PrecoService {

	@Autowired
	private PrecoRepository repo;

	public List<Preco> fromNewDto(List<PrecoNewDTO> precos, Produto obj) {
		return precos.stream().map(x -> new Preco(null, obj, x.getValor(), x.getTipo())).collect(Collectors.toList());
	}

	public List<Preco> fromDto(List<PrecoDTO> precos, Produto obj) {
		return precos.stream().map(x -> new Preco(x.getId(), obj, x.getValor(), x.getTipo()))
				.collect(Collectors.toList());
	}

	public BigDecimal valorFromDTO(PrecoTipoDTO dto, ProdutoIdDTO produto) {
		Optional<BigDecimal> valor = repo.findValorByTipoAndProduto(dto.getTipo().getCod(),
				new Produto(produto.getId()));
		return valor.orElseThrow(
				() -> new ObjectNotFoundException("Valor não encontrado! TipoPreco: " + dto.getTipo().getDescricao()
						+ " Id Produto: " + produto.getId() + ", Tipo: " + Preco.class.getName()));
	}
}
