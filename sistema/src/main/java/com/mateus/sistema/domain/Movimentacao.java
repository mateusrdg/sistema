package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import com.mateus.sistema.domain.enums.TipoMovimentacao;

public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Calendar data;
	private Calendar hora;
	private BigDecimal valor;
	private Integer tipo;
	private Conta conta;

	public Movimentacao() {
	}

	public Movimentacao(Integer id, Calendar data, Calendar hora, BigDecimal valor, TipoMovimentacao tipo,
			Conta conta) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.valor = valor;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.setConta(conta);
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

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return TipoMovimentacao.toEnum(tipo);
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo.getCod();
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
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
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
