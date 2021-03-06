package com.mateus.sistema.domain.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mateus.sistema.domain.enums.EstadoPagamento;

@Entity(name = "FormaPagamentoCompra")
@Table(name = "forma_pagamento_compra")
public class FormaPagamentoCompra extends FormaPagamentoPedido implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra pedido;

	@OneToMany(mappedBy = "formaPagamentoCompra",  cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<ParcelaCompra> parcelas = new ArrayList<ParcelaCompra>();

	@OneToOne(mappedBy = "formaPagamentoPedido",  cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private ContaPagar conta;

	public FormaPagamentoCompra() {
	}

	public FormaPagamentoCompra(Long id, Compra pedido, FormaPagamento formaPagamento, Calendar data, BigDecimal valor,
			EstadoPagamento estado) {
		super(id, formaPagamento, data, valor, estado);
		this.pedido = pedido;
	}
	
	@Override 
	public List<? extends Parcela> getParcelas(){
		return this.parcelas;
	}

	public void setParcelas(List<ParcelaCompra> parcelas) {
		this.parcelas = parcelas;
	}

	public Compra getPedido() {
		return pedido;
	}

	public void setPedido(Compra pedido) {
		this.pedido = pedido;
	}

	@Override
	public Conta getConta() {
		return this.conta;
	}

	public void setContaPagar(ContaPagar conta) {
		this.conta = conta;
	}

	@Override
	public BigDecimal getValorTotalParcelas() {
		return parcelas.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
}
