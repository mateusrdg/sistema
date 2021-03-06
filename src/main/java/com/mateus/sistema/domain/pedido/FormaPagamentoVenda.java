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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mateus.sistema.domain.enums.EstadoPagamento;

@Entity(name = "FormaPagamentoVenda")
@Table(name = "forma_pagamento_venda")
public class FormaPagamentoVenda extends FormaPagamentoPedido implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda pedido;

	@JsonManagedReference
	@OneToMany(mappedBy = "formaPagamentoVenda", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE })
	private List<ParcelaVenda> parcelas = new ArrayList<ParcelaVenda>();

	@OneToOne(mappedBy = "formaPagamentoVenda", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE })
	private ContaReceber conta;

	public FormaPagamentoVenda() {
	}

	public FormaPagamentoVenda(Long id, Venda pedido, FormaPagamento formaPagamento, Calendar data, BigDecimal valor,
			EstadoPagamento estado) {
		super(id, formaPagamento, data, valor, estado);
		this.pedido = pedido;
	}

	public Venda getPedido() {
		return pedido;
	}

	public void setPedido(Venda pedido) {
		this.pedido = pedido;
	}

	@Override 
	public List<? extends Parcela> getParcelas(){
		return this.parcelas;
	}

	public void setParcelas(List<ParcelaVenda> parcelas) {
		this.parcelas = parcelas;
	}

	@Override
	public Conta getConta() {
		return this.conta;
	}

	public void setConta(ContaReceber contaReceber) {
		this.conta = contaReceber;
	}
	
	@Override
	public BigDecimal getValorTotalParcelas() {
		return parcelas.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	
}
