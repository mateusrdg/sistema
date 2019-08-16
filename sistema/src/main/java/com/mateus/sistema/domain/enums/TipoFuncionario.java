package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.TipoFuncionario;

public enum TipoFuncionario {
	GERENTE(1, "Gerente"), 
	VENDEDOR(2, "Vendedor"),
	CAIXA(3, "Caixa"),
	ENTREGADOR(4, "Caixa"); 
	
	private Integer cod;
	private String descricao;

	private TipoFuncionario(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoFuncionario toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoFuncionario x : TipoFuncionario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
