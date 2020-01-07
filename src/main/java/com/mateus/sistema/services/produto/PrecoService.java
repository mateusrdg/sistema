package com.mateus.sistema.services.produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.produto.Preco;
import com.mateus.sistema.domain.produto.Produto;
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

	public BigDecimal getValorByTipoPrecoAndProduto(Integer codigoTipoPreco, Long produtoId) {
		Optional<BigDecimal> valor = repo.findValorByTipoAndProduto(codigoTipoPreco, new Produto(produtoId));
		return valor.orElseThrow(() -> new ObjectNotFoundException(
				"Valor não encontrado! TipoPreco: " + TipoPreco.toEnum(codigoTipoPreco).getDescricao() + " Id Produto: "
						+ produtoId + ", Tipo: " + Preco.class.getName()));
	}

}
