package com.mateus.sistema.dto.response.pedido.compra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.dto.pessoa.PessoaDTO;
import com.mateus.sistema.dto.response.pedido.PedidoResponseDTO;

public class CompraResponseDTO extends PedidoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO fornecedor;
	private PessoaDTO funcionario;
	
	private List<CompraItemResponseDTO> itens = new ArrayList<CompraItemResponseDTO>();
	
	public CompraResponseDTO() {
	}

	public CompraResponseDTO(Compra compra) {
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

	public List<CompraItemResponseDTO> getItens() {
		return itens;
	}

	public void setItens(List<CompraItemResponseDTO> itens) {
		this.itens = itens;
	}

}
