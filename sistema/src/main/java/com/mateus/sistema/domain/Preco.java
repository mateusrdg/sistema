package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.enums.TipoPreco;

public class Preco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private BigDecimal valor;
	
	private Integer tipo;
	
	public Preco() {
	}

	public Preco(BigDecimal valor, TipoPreco tipo) {
		this.valor = valor;
		this.tipo = tipo.getCod();
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	public TipoPreco getTipo() {
		return TipoPreco.toEnum(tipo);
	}

	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		Preco other = (Preco) obj;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		return true;
	}

}
