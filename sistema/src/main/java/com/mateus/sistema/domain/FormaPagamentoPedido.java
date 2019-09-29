package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.mateus.sistema.domain.enums.EstadoPagamento;

@MappedSuperclass
public abstract class FormaPagamentoPedido implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "valor")
	private BigDecimal valor;
	@Column(name = "data")
	private Calendar data;
	@Column(name = "estado")
	private Integer estado;
	
	@ManyToOne
	@JoinColumn(name = "forma_pagamento_id")
	private FormaPagamento formaPagamento;


	public FormaPagamentoPedido() {
	}

	public FormaPagamentoPedido(Integer id, FormaPagamento formaPagamento, Calendar data, BigDecimal valor, EstadoPagamento estado) {
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.data = data;
		this.valor = valor;
		this.estado = (estado == null) ? null : estado.getCod();
		;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
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
	
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
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
		FormaPagamentoPedido other = (FormaPagamentoPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
