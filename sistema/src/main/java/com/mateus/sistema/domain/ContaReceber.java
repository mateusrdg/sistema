package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.EstadoPagamento;

public class ContaReceber extends Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public ContaReceber() {
	}

	public ContaReceber(Integer id, Calendar data, Calendar hora, BigDecimal valor, EstadoPagamento estado,
			Calendar dataPagamento, Calendar dataVencimento, FormaPagamentoPedido formaPagamentoPedido,
			Parcela parcela) {
		super(id, data, hora, valor, estado, dataPagamento, dataVencimento, formaPagamentoPedido, parcela);
	}

}