package com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.Parcela;
import com.mateus.sistema.domain.pedido.ParcelaCompra;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.dto.pedido.ContaDTO;

public class ParcelaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private BigDecimal valor;
	private EstadoPagamento estado;
	private Calendar dataVencimento;
	private Calendar dataPagamento;

	private ContaDTO conta;

	public ParcelaDTO() {

	}

	public ParcelaDTO(Long id, BigDecimal valor, EstadoPagamento estado, Calendar dataVencimento,
			Calendar dataPagamento) {
		this.id = id;
		this.valor = valor;
		this.estado = estado;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public ParcelaDTO(Parcela parcela) {
		this.id = parcela.getId();
		this.valor = parcela.getValor();
		this.estado = parcela.getEstado();
		this.dataVencimento = parcela.getDataVencimento();
		this.dataPagamento = parcela.getDataPagamento();
		
		if (parcela instanceof ParcelaVenda) {
			if (((ParcelaVenda) parcela).getContaReceber() != null) {
				setConta(new ContaDTO(((ParcelaVenda) parcela).getContaReceber()));
			}
		} else if (parcela instanceof ParcelaCompra) {
			if (((ParcelaCompra) parcela).getContaPagar() != null) {
				setConta(new ContaDTO(((ParcelaCompra) parcela).getContaPagar()));
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ContaDTO getConta() {
		return conta;
	}

	public void setConta(ContaDTO conta) {
		this.conta = conta;
	}

}
