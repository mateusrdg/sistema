package com.mateus.sistema.dto.pedido.compra;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoDTO;
import com.mateus.sistema.dto.pedido.item.CompraItemDTO;
import com.mateus.sistema.dto.pessoa.fornecedor.FornecedorDTO;
import com.mateus.sistema.dto.pessoa.funcionario.FuncionarioDTO;

public class CompraNewDTO extends PedidoDTO {
	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private FornecedorDTO fornecedor;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private FuncionarioDTO funcionario;
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	List<CompraItemDTO> itens = new ArrayList<CompraItemDTO>();
	@Valid
	@NotNull(message = "preenchimento obrigatório")
	private List<FormaPagamentoPedidoDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoDTO>();

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

	public List<FormaPagamentoPedidoDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoPedidoDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public List<CompraItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<CompraItemDTO> itens) {
		this.itens = itens;
	}
}
