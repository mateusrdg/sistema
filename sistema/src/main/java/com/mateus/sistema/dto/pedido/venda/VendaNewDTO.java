package com.mateus.sistema.dto.pedido.venda;

import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.dto.pedido.PedidoNewDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.dto.pedido.item.PedidoItemNewDTO;
import com.mateus.sistema.dto.pessoa.PessoaIdDTO;
import com.mateus.sistema.dto.pessoa.cliente.ClienteDTO;
import com.mateus.sistema.dto.pessoa.funcionario.FuncionarioDTO;
import com.mateus.sistema.services.validation.VendaInsert;
@VendaInsert
public class VendaNewDTO extends PedidoNewDTO {
	private static final long serialVersionUID = 1L;

	private PessoaIdDTO cliente;
	private PessoaIdDTO vendedor;

	private List<FormaPagamentoPedidoNewDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoNewDTO>();

	public VendaNewDTO(ClienteDTO cliente, FuncionarioDTO vendedor, List<PedidoItemNewDTO> itens,
			List<FormaPagamentoPedidoNewDTO> formasPagamento) {
		super(itens);
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.formasPagamento = formasPagamento;
	}

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

}
