package com.mateus.sistema.domain;

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

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "Venda")
@Table(name = "venda")
public class Venda extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario vendedor;

	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<VendaItem> itens = new ArrayList<VendaItem>();
	
	@JsonManagedReference
	@OneToMany(mappedBy = "pedido", cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<FormaPagamentoVenda> formasPagamento = new ArrayList<FormaPagamentoVenda>();
	
	public Venda() {
	}

	public Venda(Long id, Calendar data, Cliente cliente, Funcionario vendedor) {
		super(id, data);
		this.setCliente(cliente);
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public List<VendaItem> getItens() {
		return itens;
	}

	public void setItens(List<VendaItem> itens) {
		this.itens = itens;
	}

	public List<FormaPagamentoVenda> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoVenda> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	@Override
	public Pessoa getCompradorVendedor() {
		return this.vendedor;
	}

	@Override
	public Pessoa getClienteFornecedor() {
		return this.cliente;
	}
	
}
