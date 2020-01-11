package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.dto.pedido.compra.CompraNewDTO;
import com.mateus.sistema.repository.pedido.CompraRepository;
import com.mateus.sistema.services.caixa.CaixaMovimentacaoService;
import com.mateus.sistema.services.exceptions.BusinessException;
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
	private CompraItemService itemService;
	@Autowired
	private FormaPagamentoPedidoService fppService;
	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private ContaService contaService;
	
	public Compra find(Long id) {
		Optional<Compra> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Compra.class.getName()));
	}
	
	public Compra insert(Compra obj) {
		obj.setId(null);
		contaService.geraContas(obj.getFormasPagamento());
		validar(obj);
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
		Compra compra = new Compra(null, fornecedorService.fromDto(objDto.getFornecedor()),
				funcionarioService.fromDTO(objDto.getFuncionario()));
		compra.setItens(itemService.fromDTO(objDto.getItens(), compra));
		compra.setFormasPagamento(fppService.fromDTO(objDto.getFormasPagamento(), compra));
		return compra;
	}
	
	public void validar(Compra venda) {
		itemService.validarItens(venda.getItens());
		if (!(venda.getValorTotal().compareTo(venda.getValorTotalFormasPagamento()) == 0)) {
			throw new BusinessException("valor total do itens deve ser igual ao valor total das formas de pagamento");
		}
		fppService.validarFormasPagamentoPedido(venda.getFormasPagamento());
		
	}
}
