package com.mateus.sistema.dto.produto.preco;

import java.io.Serializable;
import java.math.BigDecimal;

import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.produto.Preco;
import com.mateus.sistema.dto.EntidadeBaseId;

public class PrecoDTO extends EntidadeBaseId implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal valor;
	private TipoPreco tipo;

	public PrecoDTO() {
	}

	public PrecoDTO(Long id, BigDecimal valor, TipoPreco tipo) {
		super(id);
		this.valor = valor;
		this.tipo = (tipo == null) ? null : tipo;
	}
	
	public PrecoDTO(Preco preco) {
		super(preco.getId());
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
}
