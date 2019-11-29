package com.mateus.sistema.services.pessoa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.domain.pessoa.Cliente;
import com.mateus.sistema.dto.pessoa.cliente.ClienteDTO;
import com.mateus.sistema.dto.pessoa.cliente.ClienteNewDTO;
import com.mateus.sistema.repository.pessoa.ClienteRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
	@Autowired
	private PessoaService pessoaService;

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
		pessoaService.insertEnderecos(obj);
		pessoaService.insertTelefones(obj);
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		pessoaService.updateEnderecos(newObj);
		pessoaService.updateTelefones(newObj);
		return repo.save(newObj);
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			pessoaService.deleteEnderecos(id, TipoPessoa.CLIENTE);
			pessoaService.deleteTelefones(id, TipoPessoa.CLIENTE);
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
		Cliente obj = new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getCpfCnpj(),
				objDto.getTipoCliente());
		pessoaService.enderecosFromDto(obj, objDto);
		pessoaService.telefonesFromDto(obj, objDto);
		return obj;
	}

	public Cliente fromDto(ClienteNewDTO objDto) {
		Cliente obj = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfCnpj(),
				objDto.getTipoCliente());
		pessoaService.enderecosFromDto(obj, objDto);
		pessoaService.telefonesFromDto(obj, objDto);
		return obj;
	}
}
