package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.enums.TipoConta;

@Entity
@Table(name = "conta_pagar")
public class ContaPagar extends Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "forma_pagamento_compra_id")
	private FormaPagamentoCompra formaPagamentoPedido;
	
	@OneToOne
	@JoinColumn(name = "parcela_compra_id")
	private ParcelaCompra parcela;

	
	public ContaPagar() {
	}

	public ContaPagar(Integer id, Calendar data, Calendar hora, BigDecimal valor, EstadoPagamento estado,
			Calendar dataPagamento, Calendar dataVencimento, FormaPagamentoCompra formaPagamentoPedido,
			ParcelaCompra parcela) {
		super(id, TipoConta.PAGAR, data, hora, valor, estado, dataPagamento, dataVencimento);
		this.formaPagamentoPedido = formaPagamentoPedido;
		this.parcela = parcela;
	}

	public FormaPagamentoCompra getFormaPagamentoPedido() {
		return formaPagamentoPedido;
	}

	public void setFormaPagamentoPedido(FormaPagamentoCompra formaPagamentoPedido) {
		this.formaPagamentoPedido = formaPagamentoPedido;
	}

	public ParcelaCompra getParcela() {
		return parcela;
	}

	public void setParcela(ParcelaCompra parcela) {
		this.parcela = parcela;
	}

	
}
