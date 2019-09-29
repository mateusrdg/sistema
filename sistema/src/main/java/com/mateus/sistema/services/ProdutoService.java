package com.mateus.sistema.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Grupo;
import com.mateus.sistema.domain.Produto;
import com.mateus.sistema.dto.ProdutoNewDTO;
import com.mateus.sistema.repository.PrecoRepository;
import com.mateus.sistema.repository.ProdutoRepository;
import com.mateus.sistema.repository.ProdutoSubgrupoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private ProdutoSubgrupoRepository produtoSubgrupoRepository;
	@Autowired
	private PrecoRepository precoRepo;
	
	public Produto find(Long id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Grupo.class.getName()));
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}
	
	public Produto insert (Produto obj) {
		obj.setId(null);
		obj = repo.save(obj);
		produtoSubgrupoRepository.saveAll(obj.getProdutoSubgrupo());
		precoRepo.saveAll(obj.getPrecos());
		return obj;
	}
	
	public Produto fromDto (ProdutoNewDTO objDto) {
		Produto produto = new Produto(null, objDto.getDescricao(), objDto.getReferencia(), Calendar.getInstance(), true);
		return produto;
	}
}
