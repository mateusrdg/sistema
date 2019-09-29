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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.enums.EstadoPagamento;

@Entity(name = "FormaPagamentoVenda")
@Table(name = "forma_pagamento_venda")
public class FormaPagamentoVenda extends FormaPagamentoPedido implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda pedido;

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

	public List<ParcelaVenda> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaVenda> parcelas) {
		this.parcelas = parcelas;
	}

}
