package com.mateus.sistema.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Funcionario;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.dto.FuncionarioDTO;
import com.mateus.sistema.repository.EnderecoRepository;
import com.mateus.sistema.repository.FuncionarioRepository;
import com.mateus.sistema.repository.TelefoneRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class FuncionarioService {
	@Autowired
	private FuncionarioRepository repo;
	@Autowired
	private PessoaService pessoaService;
	@Autowired
	private EnderecoRepository enderecoRepo;
	@Autowired
	private TelefoneRepository telefoneRepository;

	public Funcionario find(Long id) {
		Optional<Funcionario> obj = repo.findById(id);
		Funcionario pessoa = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Funcionario.class.getName()));
		pessoa.getEnderecos().addAll(pessoaService.findEnderecos(pessoa.getId(), TipoPessoa.FUNCIONARIO));
		pessoa.getTelefones().addAll(pessoaService.findTelefones(pessoa.getId(), TipoPessoa.FUNCIONARIO));
		return pessoa;
	}

	public Funcionario insert(Funcionario obj) {
		obj.setId(null);
		obj = repo.save(obj);
		enderecoRepo.saveAll(obj.getEnderecos());
		telefoneRepository.saveAll(obj.getTelefones());
		return obj;
	}

	public Funcionario update(Funcionario obj) {
		Funcionario newObj = find(obj.getId());
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

	public List<Funcionario> findAll() {
		return repo.findAll();
	}

	private void updateData(Funcionario newObj, Funcionario obj) {
		pessoaService.updateData(newObj, obj);
		newObj.setTipo(obj.getTipoFuncionario());
	}

	public Funcionario fromDto(FuncionarioDTO objDto) {
		return new Funcionario(objDto.getId(), objDto.getNome(), objDto.getEmail(), objDto.getDataCadastro(),
				objDto.getCpfCnpj(), objDto.getTipoFuncionario());
	}

	//public Funcionario fromDto(FuncionarioNewDTO objDto) {
	//	return new Funcionario(null, objDto.getNome(), objDto.getEmail(), Calendar.getInstance(), objDto.getCpfCnpj(),objDto.getTipoFuncionario());
	//}

}
