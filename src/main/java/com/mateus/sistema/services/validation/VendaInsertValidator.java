package com.mateus.sistema.services.validation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.mateus.sistema.domain.enums.TipoFormaPagamento;
import com.mateus.sistema.domain.pedido.FormaPagamento;
import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaNewDTO;
import com.mateus.sistema.dto.pedido.item.VendaItemNewDTO;
import com.mateus.sistema.dto.pedido.venda.VendaNewDTO;
import com.mateus.sistema.repository.pedido.FormaPagamentoRepository;
import com.mateus.sistema.repository.pessoa.ClienteRepository;
import com.mateus.sistema.repository.pessoa.FuncionarioRepository;
import com.mateus.sistema.repository.produto.EstoqueRepository;
import com.mateus.sistema.repository.produto.PrecoRepository;
import com.mateus.sistema.repository.produto.ProdutoEstoqueRepository;
import com.mateus.sistema.repository.produto.ProdutoRepository;
import com.mateus.sistema.resources.exceptions.FieldMessage;

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
	@Autowired
	private PrecoRepository precoRepo;
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepo;

	@Override
	public void initialize(VendaInsert ann) {
	}

	@Override
	public boolean isValid(VendaNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (!clienteRepo.findById(objDto.getCliente().getId()).isPresent()) {
			list.add(new FieldMessage("cliente", "cliente não localizado"));
		}

		if (!funcionarioRepo.findById(objDto.getVendedor().getId()).isPresent()) {
			list.add(new FieldMessage("vendedor", "vendedor não localizado"));
		}

		for (VendaItemNewDTO item : objDto.getItens()) {

			Produto p = new Produto();
			p.setId(item.getProduto().getId());

			if (!produtoRepo.findById(p.getId()).isPresent()) {
				list.add(new FieldMessage("itens", "produto inexistente"));
			}

			Estoque e = new Estoque(item.getEstoque().getId());

			if (!estoqueRepo.findById(e.getId()).isPresent()) {
				list.add(new FieldMessage("itens", "estoque inexistente"));
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

			Optional<BigDecimal> preco = precoRepo.findValorByTipoAndProduto(item.getTipoPreco().getCod(), p);
			if (!preco.isPresent()) {
				list.add(new FieldMessage("itens", "não existe relação entre produto e preco informados"));
				item.setPreco(new BigDecimal(0));
			} else {
				item.setPreco(preco.get());
			}
		}

		if (!(objDto.getValorTotal().compareTo(objDto.getValorTotalFormasPagamento()) == 0)) {
			list.add(new FieldMessage("formasPagamento",
					"valor total do itens deve ser igual ao valor total das formas de pagamento"));
		}

		for (FormaPagamentoPedidoNewDTO formaPagamentoPedido : objDto.getFormasPagamento()) {
			Optional<FormaPagamento> formaPagamento = formaPagamentoRepo
					.findById(formaPagamentoPedido.getFormaPagamento().getId());

			if (!formaPagamento.isPresent()) {
				list.add(new FieldMessage("formasPagamento", "Forma de pagamento inválida"));
			} else if (formaPagamento.get().getTipo() == TipoFormaPagamento.PRAZO) {
				if (!(formaPagamentoPedido.getValor().compareTo(formaPagamentoPedido.getValorTotalParcelas()) == 0)) {
					list.add(new FieldMessage("formasPagamento",
							"valor total das parcelas deve ser igual ao valor da forma de pagamento associada"));
				} else {
					for (ParcelaNewDTO parcelaDto : formaPagamentoPedido.getParcelas()) {
						if (!(parcelaDto.getValor().compareTo(parcelaDto.getConta().getValor()) == 0)) {
							list.add(new FieldMessage("formasPagamento", "valor da parcela difere do valor do conta a receber"));
						}
					}
				}

			} else {
				if (!formaPagamentoPedido.getParcelas().isEmpty()) {
					list.add(new FieldMessage("formasPagamento", "forma de pagamento não permite parcelamento"));
				}
				if (formaPagamentoPedido.getConta() == null) {
					list.add(new FieldMessage("formasPagamento", "conta a receber não foi criada"));
				} else if (!(formaPagamentoPedido.getValor().compareTo(formaPagamentoPedido.getConta().getValor()) == 0)) {
					list.add(new FieldMessage("formasPagamento",
							"valor da forma de pagamento difere do valor do conta a receber"));
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
