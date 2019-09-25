package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Compra")
@Table(name = "compra")
public class Compra extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
	private Fornecedor fornecedor;
	
	@OneToMany(mappedBy = "pedido")
	private List<CompraItem> itens = new ArrayList<CompraItem>();
	
	
	@OneToMany(mappedBy = "pedido")
	private List<FormaPagamentoCompra> pagamentos = new ArrayList<FormaPagamentoCompra>();
	
	public Compra() {
	}
	
	public Compra(Integer id, Calendar data, Fornecedor fornecedor, Funcionario vendedor) {
		super(id, data);
		setFornecedor(fornecedor);
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
}
