package com.mateus.sistema.services.pedido.venda;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.venda.VendaDTO;
import com.mateus.sistema.repository.pedido.VendaRepository;
import com.mateus.sistema.services.ContaService;
import com.mateus.sistema.services.caixa.CaixaMovimentacaoService;
import com.mateus.sistema.services.exceptions.BusinessException;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;
import com.mateus.sistema.services.pedido.formaPagamentoPedido.FormaPagamentoPedidoService;
import com.mateus.sistema.services.pessoa.ClienteService;
import com.mateus.sistema.services.pessoa.FuncionarioService;
import com.mateus.sistema.services.produto.EstoqueService;
import com.mateus.sistema.services.produto.EstoqueService.Operacao;

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

	public Venda insert(VendaDTO objDto) {
		Venda obj = fromDTO(objDto);
		obj.setId(null);
		contaService.geraContas(obj.getFormasPagamento());
		validar(obj);
		obj = repo.save(obj);
		caixaMovService.geraCaixa(obj);
		estoqueService.atualizaEstoque(obj.getItens(), Operacao.SUBTRAIR);
		return obj;
	}

	public Venda update(VendaDTO objDto, Long id) {
		Venda obj = fromDTO(objDto);
		obj.setId(id);
		Venda newObj = find(id);
		itemService.updateItens(newObj, obj.getItens());
		updateData(newObj, obj);
		estoqueService.atualizaEstoque(newObj.getItens(), Operacao.SUBTRAIR);
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
		newObj.setCliente(obj.getCliente());
		newObj.setVendedor(obj.getVendedor());
		newObj.setData(obj.getData());
		newObj.setAtivo(obj.getAtivo());
		newObj.setItens(obj.getItens());
		newObj.setFormasPagamento(obj.getFormasPagamento());
	}

	public Venda fromDTO(VendaDTO objDto) {
		Venda venda = new Venda(((objDto.getId() == null) ? null : objDto.getId()),
				clienteService.fromDto(objDto.getCliente()), funcionarioService.fromDTO(objDto.getVendedor()));
		venda.setItens(itemService.fromDTO(objDto.getItens(), venda));
		venda.setFormasPagamento(fppService.fromDTO(objDto.getFormasPagamento(), venda));
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
