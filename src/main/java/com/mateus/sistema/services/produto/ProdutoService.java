package com.mateus.sistema.services.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.dto.produto.ProdutoDTO;
import com.mateus.sistema.dto.produto.ProdutoIdDTO;
import com.mateus.sistema.repository.produto.ProdutoRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private PrecoService precoService;
	@Autowired
	private SubgrupoService subgrupoService;
	@Autowired
	private EstoqueService estoqueService;

	public Produto find(Long id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Produto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}

	public Produto insert(ProdutoDTO objDto) {
		Produto obj = fromDTO(objDto);
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Produto update(ProdutoDTO objDto, Long id) {
		Produto obj = fromDTO(objDto);
		obj.setId(id);
		Produto newObj = find(id);
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Long id) {
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
		newObj.setPrecos(obj.getPrecos());
		newObj.setProdutoEstoques(obj.getProdutoEstoques());
		newObj.setProdutoSubgrupos(obj.getProdutoSubgrupos());
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		Produto obj = new Produto(((objDto.getId() == null) ? null : objDto.getId()), objDto.getDescricao(), objDto.getReferencia());
		obj.setPrecos(precoService.fromNewDto(objDto.getPrecos(), obj));
		obj.setProdutoEstoques(estoqueService.fromDto(objDto.getEstoques(), obj));
		obj.setProdutoSubgrupos(subgrupoService.fromDto(objDto.getSubgrupos(), obj));
		return obj;
	}

	public Produto fromDTO(ProdutoIdDTO objDto) {
		return find(objDto.getId());
	}
}
