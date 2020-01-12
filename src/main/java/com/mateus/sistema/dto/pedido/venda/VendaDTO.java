package com.mateus.sistema.dto.pedido.venda;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoDTO;
import com.mateus.sistema.dto.pessoa.PessoaIdDTO;


public class VendaDTO extends PedidoDTO {
	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private PessoaIdDTO cliente;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private PessoaIdDTO vendedor;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private List<VendaItemDTO> itens = new ArrayList<VendaItemDTO>();
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private List<FormaPagamentoPedidoDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoDTO>();

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

	public List<FormaPagamentoPedidoDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoPedidoDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public List<VendaItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemDTO> itens) {
		this.itens = itens;
	}

}
