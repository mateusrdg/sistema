package com.mateus.sistema.domain.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mateus.sistema.domain.enums.EstadoPagamento;

@Entity(name = "ParcelaCompra")
@Table(name = "parcela_compra")
public class ParcelaCompra extends Parcela implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "forma_pagamento_compra_id")
	private FormaPagamentoCompra formaPagamentoCompra;

	@OneToOne(mappedBy = "parcela")
	private ContaPagar contaPagar;

	public ParcelaCompra() {
	}

	public ParcelaCompra(Long id, FormaPagamentoCompra formaPagamentoCompra, BigDecimal valor,
			EstadoPagamento estado, Calendar dataVencimento, Calendar dataPagamento) {
		super(id, valor, estado, dataVencimento, dataPagamento);
		this.formaPagamentoCompra = formaPagamentoCompra;
	}

	public FormaPagamentoCompra getFormaPagamento() {
		return formaPagamentoCompra;
	}

	public void setFormaPagamento(FormaPagamentoCompra formaPagamentoCompra) {
		this.formaPagamentoCompra = formaPagamentoCompra;
	}

}
