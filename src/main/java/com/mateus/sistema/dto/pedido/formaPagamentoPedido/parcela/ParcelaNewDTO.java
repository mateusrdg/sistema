package com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.Parcela;
import com.mateus.sistema.dto.pedido.ContaNewDTO;

public class ParcelaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	@NotNull(message = "Preenchimento obrigatório")
	private BigDecimal valor;
	@NotNull(message = "Preenchimento obrigatório")
	private EstadoPagamento estado;
	@NotNull(message = "Preenchimento obrigatório")
	private Calendar dataVencimento;
	private Calendar dataPagamento;
	@Valid
	@NotNull(message = "Preenchimento obrigatório")
	private ContaNewDTO conta;

	public ParcelaNewDTO() {

	}

	public ParcelaNewDTO(Parcela parcela) {
		this.valor = parcela.getValor();
		this.estado = parcela.getEstado();
		this.dataVencimento = parcela.getDataVencimento();
		this.dataPagamento = parcela.getDataPagamento();
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

	public ContaNewDTO getConta() {
		return conta;
	}

	public void setConta(ContaNewDTO conta) {
		this.conta = conta;
	}

}
