package com.mateus.sistema.services.pessoa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.repository.produto.SubgrupoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class TelefoneService {
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
}
