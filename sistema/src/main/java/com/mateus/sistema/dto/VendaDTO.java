package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.FormaPagamentoVenda;
import com.mateus.sistema.domain.Venda;
import com.mateus.sistema.domain.VendaItem;

public class VendaDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private ClienteDTO cliente;
	private FuncionarioDTO vendedor;
	private List<VendaItemDTO> itens = new ArrayList<VendaItemDTO>();
	private List<FormaPagamentoVendaDTO> formasPagamento = new ArrayList<FormaPagamentoVendaDTO>();

	public VendaDTO() {
	}

	public VendaDTO(Integer id, Calendar data, ClienteDTO cliente, FuncionarioDTO vendedor, List<VendaItemDTO> itens,
			List<FormaPagamentoVendaDTO> formasPagamento) {
		super(id, data);
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.itens = itens;
		this.formasPagamento = formasPagamento;
	}

	public VendaDTO(Venda venda) {
		super(venda.getId(), venda.getData());
		this.cliente = new ClienteDTO(venda.getCliente());
		this.vendedor = new FuncionarioDTO(venda.getVendedor());
		for (FormaPagamentoVenda formaPagamentoPedido : venda.getFormasPagamento()) {
			this.formasPagamento.addAll(Arrays.asList(new FormaPagamentoVendaDTO(formaPagamentoPedido)));
		}

		for (VendaItem itens : venda.getItens()) {
			this.itens.addAll(Arrays.asList(new VendaItemDTO(itens)));
		}
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public FuncionarioDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(FuncionarioDTO vendedor) {
		this.vendedor = vendedor;
	}

	public List<VendaItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemDTO> itens) {
		this.itens = itens;
	}

	public List<FormaPagamentoVendaDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoVendaDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

}
