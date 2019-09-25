package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.Calendar;

import com.mateus.sistema.domain.Pedido;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Calendar data;
	
	public PedidoDTO() {
	}
	
	public PedidoDTO(Integer id, Calendar data) {
		this.id = id;
		this.data = data;
	}
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.data = pedido.getData();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	
}
