package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Cliente;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.repository.ClienteRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	@Autowired
	private PessoaService pessoaService;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		Cliente pessoa = obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		pessoa.getEnderecos().addAll(pessoaService.findEnderecos(pessoa.getId(), TipoPessoa.CLIENTE));
		pessoa.getTelefones().addAll(pessoaService.findTelefones(pessoa.getId(), TipoPessoa.CLIENTE));
		return pessoa;
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}
}
