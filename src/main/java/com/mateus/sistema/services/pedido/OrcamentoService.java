package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.dto.pedido.orcamento.OrcamentoNewDTO;
import com.mateus.sistema.repository.pedido.OrcamentoRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;
import com.mateus.sistema.services.pessoa.ClienteService;
import com.mateus.sistema.services.pessoa.FuncionarioService;

@Service
public class OrcamentoService {
	@Autowired
	private OrcamentoRepository repo;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private OrcamentoItemService itemService;

	public Orcamento find(Long id) {
		Optional<Orcamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Orcamento.class.getName()));
	}

	public Orcamento insert(Orcamento obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public List<Orcamento> findAll() {
		return repo.findAll();
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir!");
		}
	}

	public Orcamento fromDTO(OrcamentoNewDTO objDto) {
		Orcamento orcamento = new Orcamento(null, clienteService.fromDto(objDto.getCliente()),
				funcionarioService.fromDTO(objDto.getVendedor()), false);
		orcamento.setItens(itemService.fromNewDTO(objDto.getItens(), orcamento));

		return orcamento;
	}
}
