package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Orcamento;
import com.mateus.sistema.repository.OrcamentoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class OrcamentoService {
	@Autowired
	private OrcamentoRepository repo;
		
	public Orcamento find(Integer id) {
		Optional<Orcamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Orcamento.class.getName()));
	}

	public List<Orcamento> findAll() {
		return repo.findAll();
	}
}
