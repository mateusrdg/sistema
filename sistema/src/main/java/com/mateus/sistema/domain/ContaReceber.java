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

@Entity(name = "ContaReceber")
@Table(name = "conta_receber")
public class ContaReceber extends Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@OneToOne
	@JoinColumn(name = "forma_pagamento_venda_id")
	private FormaPagamentoVenda formaPagamentoVenda;

	
	@OneToOne
	@JoinColumn(name = "parcela_venda_id")
	private ParcelaVenda parcela;

	public ContaReceber() {
	}

	public ContaReceber(Long id, Calendar data, Calendar hora, BigDecimal valor, EstadoPagamento estado,
			Calendar dataPagamento, Calendar dataVencimento, FormaPagamentoVenda formaPagamentoPedido,
			ParcelaVenda parcela) {
		super(id, TipoConta.RECEBER, data, hora, valor, estado, dataPagamento, dataVencimento);
		this.formaPagamentoVenda = formaPagamentoPedido;
		this.parcela = parcela;
	}

	public FormaPagamentoVenda getFormaPagamentoPedido() {
		return formaPagamentoVenda;
	}

	public void setFormaPagamentoPedido(FormaPagamentoVenda formaPagamentoPedido) {
		this.formaPagamentoVenda = formaPagamentoPedido;
	}

	public ParcelaVenda getParcela() {
		return parcela;
	}

	public void setParcela(ParcelaVenda parcela) {
		this.parcela = parcela;
	}

}
