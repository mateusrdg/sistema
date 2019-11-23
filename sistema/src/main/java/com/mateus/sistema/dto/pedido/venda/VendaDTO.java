package com.mateus.sistema.dto.pedido.venda;

import java.io.Serializable;

import com.mateus.sistema.domain.pedido.Pedido;
import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class VendaDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO cliente;
	private PessoaDTO vendedor;
	
	public VendaDTO() {
	}

	public VendaDTO(Pedido pedido) {
		super(pedido);
		this.cliente = new PessoaDTO(pedido.getClienteFornecedor());
		this.vendedor = new PessoaDTO(pedido.getCompradorVendedor());
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

	

}
