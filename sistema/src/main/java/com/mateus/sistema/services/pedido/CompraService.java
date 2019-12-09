package com.mateus.sistema.services.pedido;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.dto.pedido.compra.CompraNewDTO;
import com.mateus.sistema.repository.pedido.CompraRepository;
import com.mateus.sistema.services.caixa.CaixaMovimentacaoService;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;
import com.mateus.sistema.services.pessoa.FornecedorService;
import com.mateus.sistema.services.pessoa.FuncionarioService;
import com.mateus.sistema.services.produto.EstoqueService;

@Service
public class CompraService {
	@Autowired
	private CompraRepository repo;
	@Autowired
	private CaixaMovimentacaoService caixaMovService;
	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private FormaPagamentoPedidoService fppService;
	@Autowired
	private EstoqueService estoqueService;
	
	public Compra find(Long id) {
		Optional<Compra> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Compra.class.getName()));
	}
	
	public Compra insert(Compra obj) {
		obj.setId(null);
		obj = repo.save(obj);
		caixaMovService.geraCaixa(obj);
		estoqueService.geraEntradas(obj.getItens());
		return obj;
	}

	public List<Compra> findAll() {
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

	public Compra fromDTO(CompraNewDTO objDto) {
		Compra compra = new Compra(null, Calendar.getInstance(), fornecedorService.fromDto(objDto.getFornecedor()),
				funcionarioService.fromDto(objDto.getFuncionario()));
		compra.setItens(itemService.fromDTO(objDto.getItens(), compra));
		compra.setFormasPagamento(fppService.fromNewDto(objDto.getFormasPagamento(), compra));
		return compra;
	}
}
