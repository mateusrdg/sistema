package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Grupo;
import com.mateus.sistema.domain.Venda;
import com.mateus.sistema.repository.VendaRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	@Autowired
	private VendaRepository repo;
		
	public Venda find(Integer id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Grupo.class.getName()));
	}

	public List<Venda> findAll() {
		return repo.findAll();
	}
}
