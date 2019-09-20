package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Cliente;
import com.mateus.sistema.domain.PessoaEndereco;
import com.mateus.sistema.repository.ClienteRepository;
import com.mateus.sistema.repository.PessoaEnderecoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	@Autowired 
	private PessoaEnderecoRepository pessoaEndRepo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		Cliente cliente = obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		List<PessoaEndereco> list = pessoaEndRepo.findByTipoAndPessoa_id( cliente.getTipoPessoa(), cliente.getId());
		return cliente;
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}
}
