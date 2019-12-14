package com.mateus.sistema.dto.pedido.orcamento;

import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.dto.pedido.PedidoNewDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.dto.pedido.item.PedidoItemNewDTO;
import com.mateus.sistema.dto.pedido.item.VendaItemNewDTO;
import com.mateus.sistema.dto.pessoa.cliente.ClienteDTO;
import com.mateus.sistema.dto.pessoa.funcionario.FuncionarioDTO;

public class OrcamentoNewDTO extends PedidoNewDTO {
	private static final long serialVersionUID = 1L;

	private ClienteDTO cliente;
	private FuncionarioDTO vendedor;
	
	List<VendaItemNewDTO> itens = new ArrayList <VendaItemNewDTO>();
	
	public OrcamentoNewDTO(ClienteDTO cliente, FuncionarioDTO vendedor, List<PedidoItemNewDTO> itens,
			List<FormaPagamentoPedidoNewDTO> formasPagamento) {
		
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
	
	public List<VendaItemNewDTO> getItens() {
		return itens;
	}

	public void setItens(List<VendaItemNewDTO> itens) {
		this.itens = itens;
	}

}
