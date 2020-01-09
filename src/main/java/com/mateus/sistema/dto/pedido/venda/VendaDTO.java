package com.mateus.sistema.dto.pedido.venda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pedido.item.VendaItemDTO;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class VendaDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO cliente;
	private PessoaDTO vendedor;
	
	private List<VendaItemDTO> itens = new ArrayList<VendaItemDTO>();
	
	public VendaDTO() {
	}

	public VendaDTO(Venda venda) {
		super(venda);
		this.cliente = new PessoaDTO(venda.getClienteFornecedor());
		this.vendedor = new PessoaDTO(venda.getCompradorVendedor());
		itens = venda.getItens().stream().map(obj -> new VendaItemDTO(obj))
				.collect(Collectors.toList());
	}

	public VendaDTO(Orcamento orcamento) {
		super(orcamento);
		this.cliente = new PessoaDTO(orcamento.getClienteFornecedor());
		this.vendedor = new PessoaDTO(orcamento.getCompradorVendedor());
		itens = orcamento.getItens().stream().map(obj -> new VendaItemDTO(obj))
				.collect(Collectors.toList());
	}

	public PessoaDTO getCliente() {
		return cliente;
	}

	public void setCliente(PessoaDTO cliente) {
		this.cliente = cliente;
	}

	public PessoaDTO getVendedor() {
		return vendedor;
	}

	public void setVendedor(PessoaDTO vendedor) {
		this.vendedor = vendedor;
	}

	public List<VendaItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemDTO> itens) {
		this.itens = itens;
	}

	

}
