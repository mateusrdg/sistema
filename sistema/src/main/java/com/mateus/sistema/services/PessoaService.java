package com.mateus.sistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Pessoa;
import com.mateus.sistema.domain.PessoaEndereco;
import com.mateus.sistema.domain.PessoaTelefone;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.repository.EnderecoRepository;
import com.mateus.sistema.repository.PessoaEnderecoRepository;
import com.mateus.sistema.repository.PessoaTelefoneRepository;
import com.mateus.sistema.repository.TelefoneRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaTelefoneRepository pessoaTelRepo;
	@Autowired
	private TelefoneRepository telefoneRepo;
	@Autowired
	private PessoaEnderecoRepository pessoaEndRepo;
	@Autowired
	private EnderecoRepository enderecoRepo;

	public void findTelefones(Pessoa pessoa, TipoPessoa tipo) {
		List<PessoaTelefone> list = pessoaTelRepo.findByTipoAndPessoaId(tipo.getCod(), pessoa.getId());
		if (!list.isEmpty()) {
			pessoa.getTelefones().addAll(telefoneRepo.findDistinctByPessoaTelefone(list));
		} 
	}

	public void findEnderecos(Pessoa pessoa, TipoPessoa tipo) {
		List<PessoaEndereco> list = pessoaEndRepo.findByTipoAndPessoaId(tipo.getCod(), pessoa.getId());
		if (!list.isEmpty()) {
			pessoa.getEnderecos().addAll(enderecoRepo.findDistinctByPessoaEndereco(list));	
		}
	}
	
	public void updateData(Pessoa newObj, Pessoa obj) {
		newObj.setId(obj.getId());
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setAtivo(obj.getAtivo());
		newObj.setCpfCnpj(obj.getCpfCnpj());
		newObj.setEnderecos(obj.getEnderecos());
		newObj.setTelefones(obj.getTelefones());
	}

}
