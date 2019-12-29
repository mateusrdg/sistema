package com.mateus.sistema.services.pedido;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.venda.VendaNewDTO;
import com.mateus.sistema.repository.pedido.VendaRepository;
import com.mateus.sistema.services.caixa.CaixaMovimentacaoService;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;
import com.mateus.sistema.services.pessoa.ClienteService;
import com.mateus.sistema.services.pessoa.FuncionarioService;
import com.mateus.sistema.services.produto.EstoqueService;
import com.mateus.sistema.services.validation.VendaValidator;

@Service
public class VendaService {
	@Autowired
	private VendaRepository repo;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private FormaPagamentoPedidoService fppService;
	@Autowired
	private CaixaMovimentacaoService caixaMovService;
	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private VendaValidator validador;
	
	public Venda find(Long id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
	}

	public Venda insert(Venda obj) {
		obj.setId(null);
		obj = repo.save(obj);
		validador.isValid(obj);
		caixaMovService.geraCaixa(obj);
		estoqueService.atualizaEstoque(obj);
		return obj;
	}

	public Venda update(Venda obj) {
		Venda newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir!");
		}
	}

	public List<Venda> findAll() {
		return repo.findAll();
	}

	private void updateData(Venda newObj, Venda obj) {
	//TODO
	}

	public Venda fromDTO(VendaNewDTO objDto) {
		Venda venda = new Venda(null, Calendar.getInstance(), clienteService.fromDto(objDto.getCliente()),
				funcionarioService.fromDto(objDto.getVendedor()));
		venda.setItens(itemService.fromDTO(objDto.getItens(), venda));
		venda.setFormasPagamento(fppService.fromNewDto(objDto.getFormasPagamento(), venda));
		return venda;
	}
}
