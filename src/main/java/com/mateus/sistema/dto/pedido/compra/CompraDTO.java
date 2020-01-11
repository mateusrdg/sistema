package com.mateus.sistema.dto.pedido.compra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.dto.pedido.PedidoResponseDTO;
import com.mateus.sistema.dto.pedido.item.CompraResponseDTO;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class CompraDTO extends PedidoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO fornecedor;
	private PessoaDTO funcionario;
	
	private List<CompraResponseDTO> itens = new ArrayList<CompraResponseDTO>();
	
	public CompraDTO() {
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

	public List<CompraResponseDTO> getItens() {
		return itens;
	}

	public void setItens(List<CompraResponseDTO> itens) {
		this.itens = itens;
	}

}
