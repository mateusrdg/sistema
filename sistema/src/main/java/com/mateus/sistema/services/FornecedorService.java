package com.mateus.sistema.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Endereco;
import com.mateus.sistema.domain.Fornecedor;
import com.mateus.sistema.domain.Telefone;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.dto.FornecedorDTO;
import com.mateus.sistema.dto.FornecedorNewDTO;
import com.mateus.sistema.repository.FornecedorRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	@Autowired
	private FornecedorRepository repo;
	@Autowired
	private PessoaService pessoaService;

	public Fornecedor find(Long id) {
		Optional<Fornecedor> obj = repo.findById(id);
		Fornecedor pessoa = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName()));
		pessoaService.findEnderecos(pessoa, TipoPessoa.FORNECEDOR);
		pessoaService.findTelefones(pessoa, TipoPessoa.FORNECEDOR);
		return pessoa;
	}

	public Fornecedor insert(Fornecedor obj) {
		obj.setId(null);
		obj = repo.save(obj);
		pessoaService.insertEnderecos(obj);
		pessoaService.insertTelefones(obj);
		return obj;
	}

	public Fornecedor update(Fornecedor obj) {
		Fornecedor newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			pessoaService.deleteEnderecos(id,TipoPessoa.FORNECEDOR);
			pessoaService.deleteTelefones(id,TipoPessoa.FORNECEDOR);
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Fornecedor> findAll() {
		return repo.findAll();
	}

	private void updateData(Fornecedor newObj, Fornecedor obj) {
		pessoaService.updateData(newObj, obj);
		newObj.setNomeFantasia(newObj.getNomeFantasia());
		;
	}

	public Fornecedor fromDto(FornecedorDTO objDto) {
		return new Fornecedor(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getDataCadastro(),
				objDto.getCpfCnpj(), objDto.getNomeFantasia());
	}

	public Fornecedor fromDto(FornecedorNewDTO objDto) {
		Fornecedor obj = new Fornecedor(null, objDto.getNome(), objDto.getEmail(), Calendar.getInstance(),
				objDto.getCpfCnpj(), objDto.getNomeFantasia());
		
		obj.setEnderecos(objDto.getEnderecos().stream().map(x -> new Endereco(null, x.getRua(), x.getNumero(),
				x.getCep(), x.getComplemento(), x.getBairro(), x.getCidade())).collect(Collectors.toList()));
		
		obj.setTelefones(objDto.getTelefones().stream().map(x -> new Telefone(null,x.getNumero())).collect(Collectors.toList()));
		
		return obj;
	}
}
