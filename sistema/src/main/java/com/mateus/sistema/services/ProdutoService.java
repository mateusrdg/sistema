package com.mateus.sistema.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Grupo;
import com.mateus.sistema.domain.Produto;
import com.mateus.sistema.dto.produto.ProdutoDTO;
import com.mateus.sistema.dto.produto.ProdutoNewDTO;
import com.mateus.sistema.repository.PrecoRepository;
import com.mateus.sistema.repository.ProdutoRepository;
import com.mateus.sistema.repository.ProdutoSubgrupoRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
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

	public Produto insert (Produto obj) {
		obj.setId(null);
		obj = repo.save(obj);
		produtoSubgrupoRepository.saveAll(obj.getProdutoSubgrupo());
		precoRepo.saveAll(obj.getPrecos());
		return obj;
	}
	
	public Produto update (Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete (Long id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<Produto> findAll() {
		return repo.findAll();
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setDescricao(obj.getDescricao());
		newObj.setReferencia(obj.getReferencia());
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setAtivo(obj.getAtivo());
	}
	
	public Produto fromDto (ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getDescricao(), objDto.getReferencia(), objDto.getDataCadastro(), objDto.getAtivo());
	}
	
	public Produto fromDto (ProdutoNewDTO objDto) {
		return new Produto(null, objDto.getDescricao(), objDto.getReferencia(), Calendar.getInstance(), true);
		
	}
	
	
}
