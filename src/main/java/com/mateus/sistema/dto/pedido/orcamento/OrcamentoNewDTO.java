package com.mateus.sistema.dto.pedido.orcamento;

import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pedido.PedidoItemDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoDTO;
import com.mateus.sistema.dto.pedido.venda.VendaItemDTO;
import com.mateus.sistema.dto.pessoa.cliente.ClienteDTO;
import com.mateus.sistema.dto.pessoa.funcionario.FuncionarioDTO;

public class OrcamentoNewDTO extends PedidoDTO {
	private static final long serialVersionUID = 1L;

	private ClienteDTO cliente;
	private FuncionarioDTO vendedor;
	
	List<VendaItemDTO> itens = new ArrayList <VendaItemDTO>();
	
	public OrcamentoNewDTO(ClienteDTO cliente, FuncionarioDTO vendedor, List<PedidoItemDTO> itens,
			List<FormaPagamentoPedidoDTO> formasPagamento) {
		
		this.cliente = cliente;
		this.vendedor = vendedor;
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

}
