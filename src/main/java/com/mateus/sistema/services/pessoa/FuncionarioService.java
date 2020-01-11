package com.mateus.sistema.services.pessoa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.domain.pessoa.Funcionario;
import com.mateus.sistema.dto.pessoa.PessoaIdDTO;
import com.mateus.sistema.dto.pessoa.funcionario.FuncionarioNewDTO;
import com.mateus.sistema.repository.pessoa.FuncionarioRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repo;
	@Autowired
	private PessoaService pessoaService;

	public Funcionario find(Long id) {
		Optional<Funcionario> obj = repo.findById(id);
		Funcionario pessoa = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
		pessoaService.findEnderecos(pessoa);
		pessoaService.findTelefones(pessoa);
		return pessoa;
	}

	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		pessoaService.insertEnderecos(obj);
		pessoaService.insertTelefones(obj);
		return obj;
	}

	public Funcionario update(Funcionario obj) {
		Funcionario newObj = find(obj.getId());
		updateData(newObj, obj);
		pessoaService.updateEnderecos(newObj);
		pessoaService.updateTelefones(newObj);
		return repo.save(newObj);
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			pessoaService.deleteEnderecos(id, TipoPessoa.FUNCIONARIO);
			pessoaService.deleteTelefones(id, TipoPessoa.FUNCIONARIO);
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Funcionario> findAll() {
		return repo.findAll();
	}

	private void updateData(Funcionario newObj, Funcionario obj) {
		pessoaService.updateData(newObj, obj);
		newObj.setTipo(obj.getTipoFuncionario());
	}

	public Funcionario fromDTO(FuncionarioNewDTO objDto) {
		Funcionario obj = new Funcionario(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfCnpj(),
				objDto.getTipoFuncionario());
		pessoaService.enderecosFromDto(obj, objDto);
		pessoaService.telefonesFromDto(obj, objDto);
		return obj;
	}

	public Funcionario fromDTO(PessoaIdDTO objDto) {
		return find(objDto.getId());
	}

}
