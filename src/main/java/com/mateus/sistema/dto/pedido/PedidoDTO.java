package com.mateus.sistema.dto.pedido;

import java.io.Serializable;
import java.util.Calendar;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Calendar data;
	
	public PedidoDTO () {
		
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
