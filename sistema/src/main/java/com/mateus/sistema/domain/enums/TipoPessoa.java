package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.TipoPessoa;

public enum TipoPessoa {
	PESSOAFISICA(1, "Pessoa Física"), 
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	private Integer cod;
	private String descricao;

	private TipoPessoa(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoPessoa toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoPessoa x : TipoPessoa.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
