package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.EstadoCaixa;

public enum EstadoCaixa {
	ABERTO(1, "Aberto"), 
	FECHADO(2, "Fechado");
	
	private Integer cod;
	private String descricao;

	private EstadoCaixa(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static EstadoCaixa toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (EstadoCaixa x : EstadoCaixa.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
