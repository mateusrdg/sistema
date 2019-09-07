package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity(name = "orcamento")
public class Orcamento extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario vendedor;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemOrcamento> itens = new ArrayList<ItemOrcamento>();
	
	private Integer faturado;

	public Orcamento() {
	}
	
	public Orcamento(Integer id, Calendar data, Calendar hora, Cliente cliente, Funcionario vendedor, Boolean faturado) {
		super(id, data, hora);
		this.setCliente(cliente);
		this.vendedor = vendedor;
		this.faturado = (faturado == true) ? 1 : 0;
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
	
	public List<ItemOrcamento> getItens() {
		return itens;
	}

	public void setItens(List<ItemOrcamento> itens) {
		this.itens = itens;
	}

	public Boolean getFaturado() {
		return  (faturado == 1) ? true : false;
	}

	public void setFaturado(Integer faturado) {
		this.faturado = faturado;
	}
	
}
