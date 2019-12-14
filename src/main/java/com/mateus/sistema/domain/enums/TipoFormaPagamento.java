package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.TipoFormaPagamento;

public enum TipoFormaPagamento {
	AVISTA(1, "A Vista"), 
	PRAZO(2, "Prazo"),
	BOLETO(3, "Boleto"),
	CARTAO(4, "Cartao");
	
	private Integer cod;
	private String descricao;

	private TipoFormaPagamento(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoFormaPagamento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoFormaPagamento x : TipoFormaPagamento.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
