package com.mateus.sistema.dto.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.EstadoPagamento;

public class ContaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal valor;
	private EstadoPagamento estado;
	private Calendar dataPagamento;
	private Calendar dataVencimento;

	public ContaNewDTO(BigDecimal valor, EstadoPagamento estado, Calendar dataPagamento, Calendar dataVencimento) {
		super();
		this.valor = valor;
		this.estado = estado;
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
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

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

}
