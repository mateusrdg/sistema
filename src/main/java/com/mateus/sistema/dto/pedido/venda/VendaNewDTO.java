package com.mateus.sistema.dto.pedido.venda;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.dto.pedido.PedidoNewDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.dto.pedido.item.VendaItemNewDTO;
import com.mateus.sistema.dto.pessoa.PessoaIdDTO;


public class VendaNewDTO extends PedidoNewDTO {
	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private PessoaIdDTO cliente;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private PessoaIdDTO vendedor;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private List<VendaItemNewDTO> itens = new ArrayList<VendaItemNewDTO>();
	@Valid
	@NotNull(message = "preenchimento obrigatório")
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

}
