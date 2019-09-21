package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Fornecedor;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.repository.FornecedorRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository repo;	
	@Autowired
	private PessoaService pessoaService;
	
	public Fornecedor find(Integer id) {
		Optional<Fornecedor> obj = repo.findById(id);
		Fornecedor pessoa = obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName()));
		pessoa.getEnderecos().addAll(pessoaService.findEnderecos(pessoa.getId(), TipoPessoa.FORNECEDOR));
		pessoa.getTelefones().addAll(pessoaService.findTelefones(pessoa.getId(), TipoPessoa.FORNECEDOR));
		return pessoa;
	}

	public List<Fornecedor> findAll() {
		return repo.findAll();
	}
}
