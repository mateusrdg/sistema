package com.mateus.sistema.dto.pedido.compra;

import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.dto.pedido.PedidoNewDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoNewDTO;
import com.mateus.sistema.dto.pedido.item.CompraItemNewDTO;
import com.mateus.sistema.dto.pessoa.fornecedor.FornecedorDTO;
import com.mateus.sistema.dto.pessoa.funcionario.FuncionarioDTO;

public class CompraNewDTO extends PedidoNewDTO {
	private static final long serialVersionUID = 1L;

	private FornecedorDTO fornecedor;
	private FuncionarioDTO funcionario;

	List<CompraItemNewDTO> itens = new ArrayList <CompraItemNewDTO>();
	private List<FormaPagamentoPedidoNewDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoNewDTO>();

//	public CompraNewDTO(FornecedorDTO fornecedor, FuncionarioDTO funcionario, List<PedidoItemNewDTO> itens,
//			List<FormaPagamentoPedidoNewDTO> formasPagamento) {
//		this.fornecedor = fornecedor;
//		this.funcionario = funcionario;
//		this.formasPagamento = formasPagamento;
//	}

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
