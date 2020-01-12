package com.mateus.sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.Conta;

public class ContaDTO extends EntidadeId implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private BigDecimal valor;
	private EstadoPagamento estado;
	@JsonFormat(pattern ="HH:mm:ss dd/MM/yyyy")
	private Calendar dataPagamento;
	@JsonFormat(pattern ="HH:mm:ss dd/MM/yyyy")
	private Calendar dataVencimento;

	public ContaDTO() {
	}
	
	public ContaDTO(Long id, BigDecimal valor, EstadoPagamento estado, Calendar dataPagamento, Calendar dataVencimento) {
		super(id);
		this.valor = valor;
		this.estado = estado;
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	
	public ContaDTO(Conta conta) {
		this.setId(conta.getId());
		this.valor = conta.getValor();
		this.estado = conta.getEstado();
		this.dataPagamento = conta.getDataPagamento();
		this.dataVencimento = conta.getDataVencimento();
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
