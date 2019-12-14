package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.TipoMovimentacao;

public enum TipoMovimentacao {
	ENTRADA(1, "Entrada"), 
	SAIDA(2, "Saída"),
	SANGRIA(3, "Sangria");
	
	private Integer cod;
	private String descricao;

	private TipoMovimentacao(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoMovimentacao toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoMovimentacao x : TipoMovimentacao.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
