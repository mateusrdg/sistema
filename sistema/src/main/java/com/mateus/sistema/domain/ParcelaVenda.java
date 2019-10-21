package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.enums.EstadoPagamento;

@Entity(name = "ParcelaVenda")
@Table(name = "parcela_venda")
public class ParcelaVenda extends Parcela implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "forma_pagamento_venda_id")
	private FormaPagamentoVenda formaPagamentoVenda;

	@OneToOne(mappedBy = "parcela")
	private ContaReceber contaReceber;

	public ParcelaVenda() {
	}

	public ParcelaVenda(Long id, FormaPagamentoVenda formaPagamentoVenda, BigDecimal valor, EstadoPagamento estado,
			Calendar dataVencimento, Calendar dataPagamento) {
		super(id, valor, estado, dataVencimento, dataPagamento);
		this.formaPagamentoVenda = formaPagamentoVenda;
	}
	@JsonIgnore
	public FormaPagamentoVenda getFormaPagamento() {
		return formaPagamentoVenda;
	}

	public void setFormaPagamento(FormaPagamentoVenda formaPagamentoVenda) {
		this.formaPagamentoVenda = formaPagamentoVenda;
	}

}
