package com.mateus.sistema.services.pedido;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.venda.VendaDTO;
import com.mateus.sistema.dto.pedido.venda.VendaNewDTO;
import com.mateus.sistema.repository.pedido.VendaRepository;
import com.mateus.sistema.services.caixa.CaixaMovimentacaoService;
import com.mateus.sistema.services.exceptions.BusinessException;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;
import com.mateus.sistema.services.pessoa.ClienteService;
import com.mateus.sistema.services.pessoa.FuncionarioService;
import com.mateus.sistema.services.produto.EstoqueService;

@Service
public class VendaService {
	@Autowired
	private VendaRepository repo;
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private VendaItemService itemService;
	@Autowired
	private FormaPagamentoPedidoService fppService;
	@Autowired
	private CaixaMovimentacaoService caixaMovService;
	@Autowired
	private EstoqueService estoqueService;
	@Autowired
	private ContaService contaService;

	public Venda find(Long id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
	}

	public Venda insert(VendaNewDTO objDto) {
		Venda obj = fromNewDTO(objDto);
		obj.setId(null);
		contaService.geraContas(obj.getFormasPagamento());
		validar(obj);
		obj = repo.save(obj);
		caixaMovService.geraCaixa(obj);
		estoqueService.atualizaEstoque(obj);
		return obj;
	}

	public Venda update(VendaDTO objDto, Long id) {
		Venda obj = fromDTO(objDto);
		obj.setId(id);
		Venda newObj = find(id);
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
		// TODO
	}

	private Venda fromDTO(VendaDTO objDto) {
		Venda obj = new Venda(null, clienteService.fromDto(objDto.getCliente()),
				funcionarioService.fromDto(objDto.getVendedor()));
		obj.setItens(itemService.fromDTO(objDto.getItens(), obj));
		obj.setFormasPagamento(fppService.fromDTO(objDto.getFormasPagamento(), obj));
		return obj;
	}

	public Venda fromNewDTO(VendaNewDTO objDto) {
		Venda venda = new Venda(null, clienteService.fromDto(objDto.getCliente()),
				funcionarioService.fromDto(objDto.getVendedor()));
		venda.setItens(itemService.fromNewDTO(objDto.getItens(), venda));
		venda.setFormasPagamento(fppService.fromNewDto(objDto.getFormasPagamento(), venda));
		return venda;
	}

	public void validar(Venda venda) {
		itemService.validarItens(venda.getItens());
		if (!(venda.getValorTotal().compareTo(venda.getValorTotalFormasPagamento()) == 0)) {
			throw new BusinessException("valor total do itens deve ser igual ao valor total das formas de pagamento");
		}
		fppService.validarFormasPagamentoPedido(venda.getFormasPagamento());

	}
}
