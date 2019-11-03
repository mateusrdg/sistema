package com.mateus.sistema.domain.pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.mateus.sistema.domain.pessoa.Cliente;
import com.mateus.sistema.domain.pessoa.Funcionario;
import com.mateus.sistema.domain.pessoa.Pessoa;
@Entity(name = "Orcamento")
public class Orcamento extends Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario vendedor;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "pedido")
	private List<OrcamentoItem> itens = new ArrayList<OrcamentoItem>();
	
	private Integer faturado;

	public Orcamento() {
	}
	
	public Orcamento(Long id, Calendar data, Cliente cliente, Funcionario vendedor, Boolean faturado) {
		super(id, data);
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
	
	public List<OrcamentoItem> getItens() {
		return itens;
	}

	public void setItens(List<OrcamentoItem> itens) {
		this.itens = itens;
	}

	public Boolean getFaturado() {
		return  (faturado == 1) ? true : false;
	}

	public void setFaturado(Integer faturado) {
		this.faturado = faturado;
	}

	@Override
	public Pessoa getCompradorVendedor() {
		return this.getVendedor();
	}

	@Override
	public Pessoa getClienteFornecedor() {
		return this.getCliente();
	}
	
}
