package com.mateus.sistema.dto.caixa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.mateus.sistema.domain.Movimentacao;
import com.mateus.sistema.domain.enums.TipoMovimentacao;

public class MovimentacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Calendar data;
	private BigDecimal valor;
	private TipoMovimentacao tipo;

	public MovimentacaoDTO() {

	}

	public MovimentacaoDTO(Calendar data, BigDecimal valor, TipoMovimentacao tipo) {
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
	}

	public MovimentacaoDTO(Movimentacao movimentacao) {
		this.data = movimentacao.getData();
		this.valor = movimentacao.getValor();
		this.tipo = movimentacao.getTipo();
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

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

}
