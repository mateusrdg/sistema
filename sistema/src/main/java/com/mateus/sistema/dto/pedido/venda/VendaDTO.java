package com.mateus.sistema.dto.pedido.venda;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Pedido;
import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pedido.formaPagamento.FormaPagamentoDTO;
import com.mateus.sistema.dto.pedido.item.PedidoItemDTO;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class VendaDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO cliente;
	private PessoaDTO vendedor;
	
	public VendaDTO() {
	}

	public VendaDTO(Long id, Calendar data, PessoaDTO cliente, PessoaDTO vendedor, List<PedidoItemDTO> itens,
			List<FormaPagamentoDTO> formasPagamento) {
		super(id, data, itens, formasPagamento);
		this.cliente = cliente;
		this.vendedor = vendedor;
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
