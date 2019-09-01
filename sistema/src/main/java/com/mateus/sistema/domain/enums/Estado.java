package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.Estado;

public enum Estado {
	DESATIVO(0, "Desativo"), 
	ATIVO(1, "Ativo");
	
	private Integer cod;
	private String descricao;

	private Estado(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static Estado toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (Estado x : Estado.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
