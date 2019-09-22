package com.mateus.sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.Preco;
import com.mateus.sistema.domain.enums.TipoPreco;

public class PrecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal valor;
	private Integer tipo;

	public PrecoDTO() {
	}

	public PrecoDTO(BigDecimal valor, TipoPreco tipo) {
		this.valor = valor;
		this.tipo = (tipo == null) ? null : tipo.getCod();
	}
	
	public PrecoDTO(Preco preco) {
		this.valor = preco.getValor();
		this.tipo = preco.getTipo().getCod();
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
}
