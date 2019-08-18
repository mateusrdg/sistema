package com.mateus.sistema.domain.enums;

import com.mateus.sistema.domain.enums.TipoPedidoVenda;

public enum TipoPedidoVenda {
	VENDA(1, "Venda"), 
	ORCAMENTO(2, "Orçamento");
	
	private Integer cod;
	private String descricao;

	private TipoPedidoVenda(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return this.cod;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static TipoPedidoVenda toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		for (TipoPedidoVenda x : TipoPedidoVenda.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido " + cod);
		
	}

}
