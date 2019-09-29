package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Compra;
import com.mateus.sistema.repository.CompraRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class CompraService {
	@Autowired
	private CompraRepository repo;
		
	public Compra find(Integer id) {
		Optional<Compra> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Compra.class.getName()));
	}

	public List<Compra> findAll() {
		return repo.findAll();
	}
}
