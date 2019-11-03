package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.CaixaMovimentacao;
import com.mateus.sistema.repository.CaixaMovimentacaoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class CaixaMovimentacaoService {
	@Autowired
	private CaixaMovimentacaoRepository repo;
		
	public CaixaMovimentacao find(Long id) {
		Optional<CaixaMovimentacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CaixaMovimentacao.class.getName()));
	}

	public List<CaixaMovimentacao> findAll() {
		return repo.findAll();
	}
}
