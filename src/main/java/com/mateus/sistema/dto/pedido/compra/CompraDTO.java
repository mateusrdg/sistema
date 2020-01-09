package com.mateus.sistema.dto.pedido.compra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.dto.pedido.PedidoDTO;
import com.mateus.sistema.dto.pedido.item.CompraItemDTO;
import com.mateus.sistema.dto.pessoa.PessoaDTO;

public class CompraDTO extends PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private PessoaDTO fornecedor;
	private PessoaDTO funcionario;
	
	private List<CompraItemDTO> itens = new ArrayList<CompraItemDTO>();
	
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

	public List<CompraItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<CompraItemDTO> itens) {
		this.itens = itens;
	}

}
