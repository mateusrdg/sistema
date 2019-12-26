package com.mateus.sistema.domain.enums;

public enum TipoPreco {
	AVISTA(1, "A Vista"), 
	APRAZO(2, "A Prazo"), 
	ATACADO(3, "Atacado");

	private Integer cod;
	private String descricao;

	private TipoPreco(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}
	
	public String getDescricao() {
		return this.descricao;
	}

	public static TipoPreco toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoPreco x : TipoPreco.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido " + cod);

	}

}
