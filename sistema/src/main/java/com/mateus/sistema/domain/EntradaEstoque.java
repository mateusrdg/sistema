package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name = "EntradaEstoque")
@Table(name = "entrada_estoque")
public class EntradaEstoque implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BigDecimal quantidade;
	private Calendar data;
	private Calendar hora;
	@OneToOne
	@JoinColumn(name = "pedido_compra_item_id")
	private ItemPedidoCompra item;
	@ManyToOne
	@JoinColumn(name = "estoque_id")
	private Estoque estoque;

	public EntradaEstoque() {
	}

	public EntradaEstoque(Integer id, Calendar data, Calendar hora, ItemPedidoCompra item, Estoque estoque) {
		super();
		this.id = id;
		this.quantidade = item.getQuantidade();
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

	public ItemPedidoCompra getItem() {
		return item;
	}

	public void setItem(ItemPedidoCompra item) {
		this.item = item;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
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
