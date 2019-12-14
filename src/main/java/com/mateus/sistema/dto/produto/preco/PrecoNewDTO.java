package com.mateus.sistema.dto.produto.preco;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.produto.Preco;

public class PrecoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal valor;
	private Integer tipo;

	public PrecoNewDTO() {
	}

	public PrecoNewDTO(BigDecimal valor, TipoPreco tipo) {
		this.valor = valor;
		this.tipo = (tipo == null) ? null : tipo.getCod();
	}
	
	public PrecoNewDTO(Preco preco) {
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
