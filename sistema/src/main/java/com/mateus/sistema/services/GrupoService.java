package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Grupo;
import com.mateus.sistema.repository.GrupoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class GrupoService {
	@Autowired
	private GrupoRepository repo;
	
	public Grupo find(Long id) {
		Optional<Grupo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:"+ id + ", Tipo: " + Grupo.class.getName()));
	}

	public List<Grupo> findAll() {
		return repo.findAll();
	}
}
