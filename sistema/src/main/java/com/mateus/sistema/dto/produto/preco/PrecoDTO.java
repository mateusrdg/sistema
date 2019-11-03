package com.mateus.sistema.dto.produto.preco;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.produto.Preco;

public class PrecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private BigDecimal valor;
	private TipoPreco tipo;

	public PrecoDTO() {
	}

	public PrecoDTO(Long id, BigDecimal valor, TipoPreco tipo) {
		this.setId(id);
		this.valor = valor;
		this.tipo = (tipo == null) ? null : tipo;
	}
	
	public PrecoDTO(Preco preco) {
		this.id = preco.getId();
		this.valor = preco.getValor();
		this.tipo = preco.getTipo();
	}
	
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	
	public TipoPreco getTipo() {
		return tipo;
	}

	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
