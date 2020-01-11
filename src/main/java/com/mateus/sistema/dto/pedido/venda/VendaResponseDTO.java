package com.mateus.sistema.dto.pedido.venda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.PedidoResponseDTO;
import com.mateus.sistema.dto.pedido.item.VendaItemResponseDTO;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class VendaResponseDTO extends PedidoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO cliente;
	private PessoaDTO vendedor;
	
	private List<VendaItemResponseDTO> itens = new ArrayList<VendaItemResponseDTO>();
	
	public VendaResponseDTO() {
	}

	public VendaResponseDTO(Venda venda) {
		super(venda);
		this.cliente = new PessoaDTO(venda.getClienteFornecedor());
		this.vendedor = new PessoaDTO(venda.getCompradorVendedor());
		itens = venda.getItens().stream().map(obj -> new VendaItemResponseDTO(obj))
				.collect(Collectors.toList());
	}

	public VendaResponseDTO(Orcamento orcamento) {
		super(orcamento);
		this.cliente = new PessoaDTO(orcamento.getClienteFornecedor());
		this.vendedor = new PessoaDTO(orcamento.getCompradorVendedor());
		itens = orcamento.getItens().stream().map(obj -> new VendaItemResponseDTO(obj))
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

	public List<VendaItemResponseDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemResponseDTO> itens) {
		this.itens = itens;
	}
}
