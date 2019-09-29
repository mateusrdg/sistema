package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Cliente;
import com.mateus.sistema.domain.Funcionario;
import com.mateus.sistema.domain.Pedido;

public class VendaDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private ClienteDTO cliente;
	private FuncionarioDTO vendedor;
	
	public VendaDTO() {
	}

	public VendaDTO(Long id, Calendar data, ClienteDTO cliente, FuncionarioDTO vendedor, List<PedidoItemDTO> itens,
			List<FormaPagamentoDTO> formasPagamento) {
		super(id, data, itens, formasPagamento);
		this.cliente = cliente;
		this.vendedor = vendedor;
	}

	public VendaDTO(Pedido pedido) {
		super(pedido);
		this.cliente = new ClienteDTO((Cliente) pedido.getClienteFornecedor());
		this.vendedor = new FuncionarioDTO((Funcionario) pedido.getCompradorVendedor());
		
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

	

}
