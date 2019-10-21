package com.mateus.sistema.dto.pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mateus.sistema.dto.pedido.item.PedidoItemNewDTO;

public class PedidoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	List<PedidoItemNewDTO> itens = new ArrayList <PedidoItemNewDTO>();

	public PedidoNewDTO() {
	}
	
	public PedidoNewDTO(List<PedidoItemNewDTO> itens) {
		this.itens = itens;
	}

	public List<PedidoItemNewDTO> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItemNewDTO> itens) {
		this.itens = itens;
	}
	
}
