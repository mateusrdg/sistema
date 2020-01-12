package com.mateus.sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.Conta;

public class ContaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Preenchimento obrigatório")
	private BigDecimal valor;
	@NotNull(message = "Preenchimento obrigatório")
	private EstadoPagamento estado;
	private Calendar dataPagamento;
	@NotNull(message = "Preenchimento obrigatório")
	private Calendar dataVencimento;

	public ContaNewDTO() {
	}
	
	public ContaNewDTO(Conta conta) {
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
