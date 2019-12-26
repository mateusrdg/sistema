package com.mateus.sistema.dto.pedido.venda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.mateus.sistema.dto.pedido.PedidoNewDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.dto.pedido.item.VendaItemNewDTO;
import com.mateus.sistema.dto.pessoa.PessoaIdDTO;
import com.mateus.sistema.services.validation.VendaInsert;

@VendaInsert
public class VendaNewDTO extends PedidoNewDTO {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Preenchimento obrigatório.")
	private Integer um;
	@NotNull(message = "Preenchimento obrigatório.")
	private PessoaIdDTO cliente;
	@NotNull(message = "Preenchimento obrigatório.")
	private PessoaIdDTO vendedor;
	
	List<VendaItemNewDTO> itens = new ArrayList<VendaItemNewDTO>();

	private List<FormaPagamentoPedidoNewDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoNewDTO>();

	public PessoaIdDTO getCliente() {
		return cliente;
	}

	public void setCliente(PessoaIdDTO cliente) {
		this.cliente = cliente;
	}

	public PessoaIdDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(PessoaIdDTO vendedor) {
		this.vendedor = vendedor;
	}

	public List<FormaPagamentoPedidoNewDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoPedidoNewDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public List<VendaItemNewDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemNewDTO> itens) {
		this.itens = itens;
	}

	@Override
	public BigDecimal calculaValorTotal() {
		return itens.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@Override
	public BigDecimal getValorTotalFormasPagamento() {
		return formasPagamento.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public Integer getUm() {
		return um;
	}

	public void setUm(Integer um) {
		this.um = um;
	}

}
