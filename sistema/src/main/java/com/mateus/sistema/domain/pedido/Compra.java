package com.mateus.sistema.domain.pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mateus.sistema.domain.pessoa.Fornecedor;
import com.mateus.sistema.domain.pessoa.Funcionario;
import com.mateus.sistema.domain.pessoa.Pessoa;

@Entity(name = "Compra")
@Table(name = "compra")
public class Compra extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy = "pedido", cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<CompraItem> itens = new ArrayList<CompraItem>();
	
	
	@OneToMany(mappedBy = "pedido", cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<FormaPagamentoCompra> formasPagamento = new ArrayList<FormaPagamentoCompra>();
	
	public Compra() {
	}
	
	public Compra(Long id, Calendar data, Fornecedor fornecedor, Funcionario funcionario) {
		super(id, data);
		setFornecedor(fornecedor);
		this.funcionario = funcionario;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<CompraItem> getItens() {
		return itens;
	}

	public void setItens(List<CompraItem> itens) {
		this.itens = itens;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<FormaPagamentoCompra> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamentos(List<FormaPagamentoCompra> pagamentos) {
		this.formasPagamento = pagamentos;
	}

	@Override
	public Pessoa getCompradorVendedor() {
		return this.funcionario;
	}

	@Override
	public Pessoa getClienteFornecedor() {
		return this.fornecedor;
	}

	
}
