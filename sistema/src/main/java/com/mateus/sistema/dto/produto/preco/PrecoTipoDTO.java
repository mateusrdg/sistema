package com.mateus.sistema.dto.produto.preco;

import java.io.Serializable;

import com.mateus.sistema.domain.enums.TipoPreco;

public class PrecoTipoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private TipoPreco tipo;
	
	public PrecoTipoDTO() {
	}

	public TipoPreco getTipo() {
		return tipo;
	}

	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}

}
