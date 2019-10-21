package com.mateus.sistema.dto.pedido.compra;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Compra;
import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoDTO;
import com.mateus.sistema.dto.pedido.item.PedidoItemDTO;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class CompraDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO fornecedor;
	private PessoaDTO funcionario;
	
	public CompraDTO() {
	}

	public CompraDTO(Long id, Calendar data, PessoaDTO fornecedor, PessoaDTO funcionario, List<PedidoItemDTO> itens,
			List<FormaPagamentoPedidoDTO> formasPagamento) {
		super(id, data,  itens, formasPagamento);
		this.fornecedor = fornecedor;
		this.funcionario = funcionario;
	}

	public CompraDTO(Compra compra) {
		super(compra);
		this.fornecedor = new PessoaDTO(compra.getFornecedor());
		this.funcionario = new PessoaDTO(compra.getFuncionario());
	}

	public PessoaDTO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(PessoaDTO fornecedor) {
		this.fornecedor = fornecedor;
	}

	public PessoaDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(PessoaDTO fornecedor) {
		this.funcionario = fornecedor;
	}

}
