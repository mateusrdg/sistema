package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Funcionario;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.repository.FuncionarioRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repo;
	@Autowired
	private PessoaService pessoaService;
	
	public Funcionario find(Integer id) {
		Optional<Funcionario> obj = repo.findById(id);
		Funcionario pessoa = obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
		pessoa.getEnderecos().addAll(pessoaService.findEnderecos(pessoa.getId(), TipoPessoa.FUNCIONARIO));
		pessoa.getTelefones().addAll(pessoaService.findTelefones(pessoa.getId(), TipoPessoa.FUNCIONARIO));
		return pessoa;
	}

	public List<Funcionario> findAll() {
		return repo.findAll();
	}
}
