package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mateus.sistema.domain.enums.EstadoPagamento;
@Entity(name = "Parcela")
@Table(name = "parcela")
public class Parcela implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "forma_pagamento_pedido_id")
	private FormaPagamentoPedido formaPagamentoPedido;
	private BigDecimal valor;
	
	private Integer estado;
	private Calendar dataVencimento;
	private Calendar dataPagamento;
	
	@OneToOne(mappedBy = "parcela")
	private ContaPagar conta;

	public Parcela() {
	}

	public Parcela(Integer id, FormaPagamentoPedido formaPagamentoPedido, BigDecimal valor, EstadoPagamento estado, Calendar dataVencimento, Calendar dataPagamento) {
		super();
		this.id = id;
		this.formaPagamentoPedido = formaPagamentoPedido;
		this.valor = valor;
		this.estado = (estado == null) ? null : estado.getCod();;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FormaPagamentoPedido getFormaPagamento() {
		return formaPagamentoPedido;
	}

	public void setFormaPagamento(FormaPagamentoPedido formaPagamento) {
		this.formaPagamentoPedido = formaPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parcela other = (Parcela) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
