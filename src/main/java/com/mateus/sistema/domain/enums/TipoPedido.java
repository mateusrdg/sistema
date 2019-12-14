package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.TipoPedido;

public enum TipoPedido {
	VENDA(1, "Venda"), 
	COMPRA(2, "Compra"), 
	ORCAMENTO(3, "Orcamento");

	private Integer cod;
	private String descricao;

	private TipoPedido(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static TipoPedido toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoPedido x : TipoPedido.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido " + cod);

	}

}
