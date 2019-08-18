package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.EstadoPagamento;

public class Parcela implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private FormaPagamento formaPagamento;
	private BigDecimal valor;
	private EstadoPagamento estado;
	private Calendar dataVencimento;
	private Calendar dataPagamento;

	public Parcela() {
	}

	public Parcela(Integer id, FormaPagamento formaPagamento, BigDecimal valor, EstadoPagamento estado, Calendar dataVencimento, Calendar dataPagamento) {
		super();
		this.id = id;
		this.formaPagamento = formaPagamento;
		this.valor = valor;
		this.estado = estado;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EstadoPagamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
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
