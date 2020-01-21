package com.mateus.sistema.services.produto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoSubgrupo;
import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.dto.produto.subgrupo.SubgrupoDTO;
import com.mateus.sistema.dto.produto.subgrupo.SubgrupoIdDTO;
import com.mateus.sistema.repository.produto.SubgrupoRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
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

	public Subgrupo insert(SubgrupoDTO objDto) {
		Subgrupo obj = fromDTO(objDto);
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Subgrupo update(SubgrupoDTO objDto, Long id) {
		Subgrupo obj = fromDTO(objDto);
		obj.setId(id);
		Subgrupo newObj = find(id);
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Subgrupo newObj, Subgrupo obj) {
		newObj.setDescricao(obj.getDescricao());
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir!");
		}
	}

	public List<Subgrupo> findAll() {
		return repo.findAll();
	}

	public Subgrupo fromDTO(SubgrupoDTO objDto) {
		return new Subgrupo(((objDto.getId() == null) ? null : objDto.getId()), objDto.getDescricao(),
				new Grupo(objDto.getGrupo().getId()));
	}

	public Subgrupo fromDTO(SubgrupoIdDTO objDto) {
		return new Subgrupo(objDto.getId());
	}

	public List<ProdutoSubgrupo> fromDto(List<SubgrupoIdDTO> subgrupos, Produto obj) {
		return subgrupos.stream().map(x -> new ProdutoSubgrupo(null, new Subgrupo(x.getId()), obj))
				.collect(Collectors.toList());
	}
}
