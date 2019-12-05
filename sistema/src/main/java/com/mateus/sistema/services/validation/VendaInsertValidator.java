package com.mateus.sistema.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.pedido.item.PedidoItemNewDTO;
import com.mateus.sistema.dto.pedido.venda.VendaNewDTO;
import com.mateus.sistema.repository.pessoa.ClienteRepository;
import com.mateus.sistema.repository.pessoa.FuncionarioRepository;
import com.mateus.sistema.repository.produto.EstoqueRepository;
import com.mateus.sistema.repository.produto.ProdutoEstoqueRepository;
import com.mateus.sistema.repository.produto.ProdutoRepository;
import com.mateus.sistema.resouces.exceptions.FieldMessage;

public class VendaInsertValidator implements ConstraintValidator<VendaInsert, VendaNewDTO> {

	@Autowired
	private ClienteRepository clienteRepo;
	@Autowired
	private FuncionarioRepository funcionarioRepo;
	@Autowired
	private ProdutoRepository produtoRepo;
	@Autowired
	private EstoqueRepository estoqueRepo;
	@Autowired
	private ProdutoEstoqueRepository peRepo;

	@Override
	public void initialize(VendaInsert ann) {
	}

	@Override
	public boolean isValid(VendaNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (!clienteRepo.findById(objDto.getCliente().getId()).isPresent()) {
			list.add(new FieldMessage("cliente", "E-mail já cadastrado"));
		}

		if (!funcionarioRepo.findById(objDto.getVendedor().getId()).isPresent()) {
			list.add(new FieldMessage("vendedor", "E-mail já cadastrado"));
		}

		for (PedidoItemNewDTO item : objDto.getItens()) {

			Produto p = new Produto();
			p.setId(item.getProduto().getId());

			if (!produtoRepo.findById(p.getId()).isPresent()) {
				list.add(new FieldMessage("itens", "produto inexistente"));
			}
		
			Estoque e = new Estoque(item.getEstoque().getId());

			if (!estoqueRepo.findById(e.getId()).isPresent()) {
				list.add(new FieldMessage("estoque", "estoque inexistente"));
			}

			Optional<ProdutoEstoque> pe = peRepo.findByProdutoAndEstoque(p, e);
			if (!pe.isPresent()) {
				list.add(new FieldMessage("itens", "não existe relação entre produto e estoque informados"));
			} else {
				ProdutoEstoque produtoEstoque = pe.get(); 
				if (item.getQuantidade().compareTo(produtoEstoque.getQuantidade()) == 1) {
					list.add(new FieldMessage("itens", "quantidade de estoque insuficiente"));
				}
			}
			
			
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
