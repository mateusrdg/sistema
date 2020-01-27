package com.mateus.sistema.services.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.dto.produto.grupo.GrupoDTO;
import com.mateus.sistema.repository.produto.GrupoRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class GrupoService {
	@Autowired
	private GrupoRepository repo;

	public Grupo find(Long id) {
		Optional<Grupo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Grupo.class.getName()));
	}

	public Grupo insert(GrupoDTO objDto) {
		Grupo obj = fromDTO(objDto);
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Grupo update(GrupoDTO objDto, Long id) {
		Grupo obj = fromDTO(objDto);
		obj.setId(id);
		Grupo newObj = find(id);
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Grupo newObj, Grupo obj) {
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

	public List<Grupo> findAll() {
		return repo.findAll();
	}

	public Grupo fromDTO(GrupoDTO objDto) {
		return new Grupo(((objDto.getId() == null) ? null : objDto.getId()), objDto.getDescricao());
	}
}
