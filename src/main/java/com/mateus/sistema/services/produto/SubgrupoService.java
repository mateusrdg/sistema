package com.mateus.sistema.services.produto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoSubgrupo;
import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.dto.produto.subgrupo.ProdutoSubgrupoDTO;
import com.mateus.sistema.dto.produto.subgrupo.SubgrupoIdDTO;
import com.mateus.sistema.repository.produto.SubgrupoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class SubgrupoService {
	@Autowired
	private SubgrupoRepository repo;

	public Subgrupo find(Long id) {
		Optional<Subgrupo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Subgrupo.class.getName()));
	}

	public List<Subgrupo> findAll() {
		return repo.findAll();
	}

	public List<ProdutoSubgrupo> fromNewDto(List<SubgrupoIdDTO> subgrupos, Produto obj) {
		return subgrupos.stream().map(x -> new ProdutoSubgrupo(null, new Subgrupo(x.getId()), obj))
				.collect(Collectors.toList());
	}

	public List<ProdutoSubgrupo> fromDto(List<ProdutoSubgrupoDTO> subgrupos, Produto obj) {
		return subgrupos.stream().map(x -> new ProdutoSubgrupo(x.getId(), new Subgrupo(x.getSubgrupo().getId()), obj))
				.collect(Collectors.toList());
	}
}
