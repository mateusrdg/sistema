package com.mateus.sistema.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Venda;
import com.mateus.sistema.dto.pedido.venda.VendaNewDTO;
import com.mateus.sistema.repository.VendaRepository;
import com.mateus.sistema.services.exceptions.DataIntegrityException;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {
	@Autowired
	private VendaRepository repo;
//	@Autowired
//	private VendaItemRepository itemRepo;
//	@Autowired
//	private FormaPagamentoVendaRepository fpvRepo;
//	@Autowired 
//	private ParcelaVendaRepository parcelaRepo;
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private FuncionarioService funcionarioService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private FormaPagamentoPedidoService fppService;

	public Venda find(Long id) {
		Optional<Venda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
	}

	public Venda insert(Venda obj) {
		obj.setId(null);
		obj = repo.save(obj);
		//obj.getItens().stream().map(x -> x.setPedido(obj));
		//itemRepo.saveAll(obj.getItens());
		//fpvRepo.saveAll(obj.getFormasPagamento());
		//for (FormaPagamentoVenda formaPagamento : obj.getFormasPagamento()) {
		//	parcelaRepo.saveAll(formaPagamento.getParcelas());
		//}
		return obj;
	}

	public Venda update(Venda obj) {
		Venda newObj = find(obj.getId());
		updateData(newObj, obj);
		// pessoaService.updateEnderecos(newObj);
		// pessoaService.updateTelefones(newObj);
		return repo.save(newObj);
	}

	public void delete(Long id) {
		repo.findById(id);
		try {
			// pessoaService.deleteEnderecos(id, TipoPessoa.Venda);
			// pessoaService.deleteTelefones(id, TipoPessoa.Venda);
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<Venda> findAll() {
		return repo.findAll();
	}

	private void updateData(Venda newObj, Venda obj) {

	}

	public Venda fromDTO(VendaNewDTO objDto) {
		return new Venda(null, Calendar.getInstance(), clienteService.fromDto(objDto.getCliente()),
				funcionarioService.fromDto(objDto.getVendedor()), itemService.fromDTO(objDto.getItens()), fppService.fromDto(objDto.getFormasPagamento()));
	}
}
