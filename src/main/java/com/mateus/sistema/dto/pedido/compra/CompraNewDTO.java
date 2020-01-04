package com.mateus.sistema.dto.pedido.compra;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.dto.pedido.PedidoNewDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.dto.pedido.item.CompraItemNewDTO;
import com.mateus.sistema.dto.pessoa.fornecedor.FornecedorDTO;
import com.mateus.sistema.dto.pessoa.funcionario.FuncionarioDTO;

public class CompraNewDTO extends PedidoNewDTO {
	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private FornecedorDTO fornecedor;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private FuncionarioDTO funcionario;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	List<CompraItemNewDTO> itens = new ArrayList<CompraItemNewDTO>();
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private List<FormaPagamentoPedidoNewDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoNewDTO>();

	public FornecedorDTO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorDTO fornecedor) {
		this.fornecedor = fornecedor;
	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public List<FormaPagamentoPedidoNewDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoPedidoNewDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public List<CompraItemNewDTO> getItens() {
		return itens;
	}

	public void setItens(List<CompraItemNewDTO> itens) {
		this.itens = itens;
	}
}
