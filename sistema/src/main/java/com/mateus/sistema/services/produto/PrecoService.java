package com.mateus.sistema.services.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Preco;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.dto.produto.preco.PrecoNewDTO;
@Service
public class PrecoService {

	public List<Preco> fromDto(List<PrecoNewDTO> precos, Produto obj) {
		return precos.stream().map(x -> new Preco(null, obj, x.getValor(), x.getTipo())).collect(Collectors.toList());
	}

}
