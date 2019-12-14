package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.TipoConta;

public enum TipoConta {
	RECEBER(0, "Receber"), 
	PAGAR(1, "Pagar");
	
	private Integer cod;
	private String descricao;

	private TipoConta(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoConta toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoConta x : TipoConta.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
