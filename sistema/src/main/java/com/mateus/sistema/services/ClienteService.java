package com.mateus.sistema.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Cliente;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.dto.ClienteDTO;
import com.mateus.sistema.dto.ClienteNewDTO;
import com.mateus.sistema.repository.ClienteRepository;
import com.mateus.sistema.repository.EnderecoRepository;
import com.mateus.sistema.repository.TelefoneRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	public Cliente find(Long id) {
		Optional<Cliente> obj = repo.findById(id);
		Cliente pessoa = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		pessoaService.findEnderecos(pessoa, TipoPessoa.CLIENTE);
		pessoaService.findTelefones(pessoa, TipoPessoa.CLIENTE);
		return pessoa;
	}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepo.saveAll(obj.getEnderecos());
		telefoneRepository.saveAll(obj.getTelefones());
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	private void updateData(Cliente newObj, Cliente obj) {
		pessoaService.updateData(newObj, obj);
		newObj.setTipo(obj.getTipoCliente());
	}

	public Cliente fromDto(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getDataCadastro(),
				objDto.getCpfCnpj(), objDto.getTipoCliente());
	}

	public Cliente fromDto(ClienteNewDTO objDto) {
		return new Cliente(null, objDto.getNome(), objDto.getEmail(), Calendar.getInstance(), null, null);
	}
}
