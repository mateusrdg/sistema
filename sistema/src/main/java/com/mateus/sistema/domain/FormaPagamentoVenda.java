package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@OneToMany(mappedBy = "formaPagamentoVenda")
	private List<ParcelaVenda> parcelas = new ArrayList<ParcelaVenda>();

	@OneToOne(mappedBy = "formaPagamentoVenda")
	private ContaReceber contaReceber;

	public FormaPagamentoVenda() {
	}

	public FormaPagamentoVenda(Long id, Venda pedido, FormaPagamento formaPagamento, Calendar data, BigDecimal valor,
			EstadoPagamento estado) {
		super(id, formaPagamento, data, valor, estado);
		this.pedido = pedido;
	}
	
	@JsonIgnore
	public Venda getPedido() {
		return pedido;
	}

	public void setPedido(Venda pedido) {
		this.pedido = pedido;
	}
	
	public ContaReceber getContaReceber() {
		return contaReceber;
	}

	public void setContaReceber(ContaReceber contaReceber) {
		this.contaReceber = contaReceber;
	}

	public List<ParcelaVenda> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaVenda> parcelas) {
		this.parcelas = parcelas;
	}

}
