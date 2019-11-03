package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.repository.pedido.OrcamentoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class OrcamentoService {
	@Autowired
	private OrcamentoRepository repo;
		
	public Orcamento find(Long id) {
		Optional<Orcamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Orcamento.class.getName()));
	}

	public List<Orcamento> findAll() {
		return repo.findAll();
	}
}
