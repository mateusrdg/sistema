package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Compra;

public class CompraDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private FornecedorDTO fornecedor;
	private FuncionarioDTO funcionario;
	
	public CompraDTO() {
	}

	public CompraDTO(Integer id, Calendar data, FornecedorDTO fornecedor, FuncionarioDTO funcionario, List<PedidoItemDTO> itens,
			List<FormaPagamentoDTO> formasPagamento) {
		super(id, data,  itens, formasPagamento);
		this.fornecedor = fornecedor;
		this.funcionario = funcionario;
	}

	public CompraDTO(Compra compra) {
		super(compra);
		this.fornecedor = new FornecedorDTO(compra.getFornecedor());
		this.funcionario = new FuncionarioDTO(compra.getFuncionario());
	}

	public FornecedorDTO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorDTO fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO fornecedor) {
		this.funcionario = fornecedor;
	}

}
