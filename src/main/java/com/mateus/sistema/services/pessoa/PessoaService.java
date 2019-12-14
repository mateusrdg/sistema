package com.mateus.sistema.services.pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.domain.pessoa.Endereco;
import com.mateus.sistema.domain.pessoa.Pessoa;
import com.mateus.sistema.domain.pessoa.PessoaEndereco;
import com.mateus.sistema.domain.pessoa.PessoaTelefone;
import com.mateus.sistema.domain.pessoa.Telefone;
import com.mateus.sistema.dto.pessoa.PessoaDTO;
import com.mateus.sistema.dto.pessoa.PessoaNewDTO;
import com.mateus.sistema.repository.pessoa.EnderecoRepository;
import com.mateus.sistema.repository.pessoa.PessoaEnderecoRepository;
import com.mateus.sistema.repository.pessoa.PessoaTelefoneRepository;
import com.mateus.sistema.repository.pessoa.TelefoneRepository;

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

	public void findTelefones(Pessoa pessoa) {
		List<PessoaTelefone> list = pessoaTelRepo.findByTipoAndPessoaId(pessoa.getTipoPessoa().getCod(),
				pessoa.getId());
		if (!list.isEmpty()) {
			pessoa.getTelefones().addAll(telefoneRepo.findDistinctByPessoaTelefone(list));
		}
	}

	public void findEnderecos(Pessoa pessoa) {
		List<PessoaEndereco> list = pessoaEndRepo.findByTipoAndPessoaId(pessoa.getTipoPessoa().getCod(),
				pessoa.getId());
		if (!list.isEmpty()) {
			pessoa.getEnderecos().addAll(enderecoRepo.findDistinctByPessoaEndereco(list));
		}
	}

	public void insertTelefones(Pessoa pessoa) {
		telefoneRepo.saveAll(pessoa.getTelefones());
		pessoaTelRepo.saveAll((pessoa.getTelefones().stream().map(obj -> new PessoaTelefone(null, pessoa, obj)))
				.collect(Collectors.toList()));
	}

	public void insertEnderecos(Pessoa pessoa) {
		enderecoRepo.saveAll(pessoa.getEnderecos());
		pessoaEndRepo.saveAll((pessoa.getEnderecos().stream().map(obj -> new PessoaEndereco(null, pessoa, obj)))
				.collect(Collectors.toList()));
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

	public void deleteEnderecos(Long id, TipoPessoa tipo) {
		pessoaEndRepo.deleteAll(pessoaEndRepo.findByTipoAndPessoaId(tipo.getCod(), id));
	}

	public void deleteTelefones(Long id, TipoPessoa tipo) {
		pessoaTelRepo.deleteAll(pessoaTelRepo.findByTipoAndPessoaId(tipo.getCod(), id));
	}

	public void updateEnderecos(Pessoa obj) {
		List<Endereco> enderecosAlterados = new ArrayList<>();
		List<PessoaEndereco> pes = new ArrayList<>();
		List<Endereco> enderecosAux = new ArrayList<>();

		enderecosAux.addAll(pessoaEndRepo.findByTipoAndPessoaId(obj.getTipoPessoa().getCod(), obj.getId()).stream()
				.map(x -> x.getEndereco()).collect(Collectors.toList()));

		for (Endereco endereco : obj.getEnderecos()) {
			if (endereco.getId() == null) {
				pes.add(new PessoaEndereco(null, obj, endereco));
			} else if (enderecosAux.contains(endereco)) {
				enderecosAlterados.add(endereco);
			} else {
				endereco.setId(null);
				pes.add(new PessoaEndereco(null, obj, endereco));
			}
		}

		for (Endereco endereco : enderecosAux) {
			if (!enderecosAlterados.contains(endereco)) {
				enderecoRepo.delete(endereco);
			}
		}

		enderecoRepo.saveAll(enderecosAlterados);
		pessoaEndRepo.saveAll(pes);
	}

	public void updateTelefones(Pessoa obj) {
		List<Telefone> telefonesAlterados = new ArrayList<>();
		List<PessoaTelefone> pts = new ArrayList<>();
		List<Telefone> telefonesAux = new ArrayList<>();

		telefonesAux.addAll(pessoaTelRepo.findByTipoAndPessoaId(obj.getTipoPessoa().getCod(), obj.getId()).stream()
				.map(x -> x.getTelefone()).collect(Collectors.toList()));

		for (Telefone telefone : obj.getTelefones()) {
			if (telefone.getId() == null) {
				pts.add(new PessoaTelefone(null, obj, telefone));
			} else if (telefonesAux.contains(telefone)) {
				telefonesAlterados.add(telefone);
			} else {
				telefone.setId(null);
				pts.add(new PessoaTelefone(null, obj, telefone));
			}
		}

		for (Telefone telefone : telefonesAux) {
			if (!telefonesAlterados.contains(telefone)) {
				telefoneRepo.delete(telefone);
			}
		}

		telefoneRepo.saveAll(telefonesAlterados);
		pessoaTelRepo.saveAll(pts);
	}

	public void telefonesFromDto(Pessoa obj, PessoaDTO objDto) {
		obj.setTelefones(objDto.getTelefones().stream().map(x -> new Telefone(x.getId(), x.getNumero()))
				.collect(Collectors.toList()));
	}

	public void enderecosFromDto(Pessoa obj, PessoaDTO objDto) {
		obj.setEnderecos(objDto.getEnderecos().stream().map(x -> new Endereco(x.getId(), x.getRua(), x.getNumero(),
				x.getCep(), x.getComplemento(), x.getBairro(), x.getCidade())).collect(Collectors.toList()));
	}

	public void telefonesFromDto(Pessoa obj, PessoaNewDTO objDto) {
		obj.setTelefones(objDto.getTelefones().stream().map(x -> new Telefone(null, x.getNumero()))
				.collect(Collectors.toList()));

	}

	public void enderecosFromDto(Pessoa obj, PessoaNewDTO objDto) {
		obj.setEnderecos(objDto.getEnderecos().stream().map(x -> new Endereco(null, x.getRua(), x.getNumero(),
				x.getCep(), x.getComplemento(), x.getBairro(), x.getCidade())).collect(Collectors.toList()));
	}

}
