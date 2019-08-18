package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

public class EntradaEstoque implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Calendar data;
	private Calendar hora;
	private ItemPedido item;
	private Estoque estoque;

	public EntradaEstoque() {
	}

	public EntradaEstoque(Integer id, Calendar data, Calendar hora, ItemPedido item, Estoque estoque) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.item = item;
		this.estoque = estoque;
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

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public ItemPedido getItem() {
		return item;
	}

	public void setItem(ItemPedido item) {
		this.item = item;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntradaEstoque other = (EntradaEstoque) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
