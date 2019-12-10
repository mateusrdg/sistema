package com.mateus.sistema.services.produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Preco;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.dto.pedido.item.VendaItemNewDTO;
import com.mateus.sistema.dto.produto.preco.PrecoDTO;
import com.mateus.sistema.dto.produto.preco.PrecoNewDTO;
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

	public BigDecimal valorFromDTO(VendaItemNewDTO dto) {
		Optional<BigDecimal> valor = repo.findValorByTipoAndProduto(dto.getTipoPreco().getCod(),
				new Produto(dto.getProduto().getId()));
		return valor.orElseThrow(
				() -> new ObjectNotFoundException("Valor não encontrado! TipoPreco: " + dto.getTipoPreco().getDescricao()
						+ " Id Produto: " + dto.getProduto().getId() + ", Tipo: " + Preco.class.getName()));
	}
}
