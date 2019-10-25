package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "VendaItem")
@Table(name = "venda_item")
public class VendaItem extends PedidoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "venda_id", referencedColumnName = "id")
	private Venda pedido;

	public VendaItem() {
	}

	public VendaItem(Long id, Venda pedido, Produto produto, BigDecimal quantidade, BigDecimal preco,
			BigDecimal desconto) {
		super(id, quantidade, preco, desconto, produto);
		this.pedido = pedido;

	}
	
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Venda pedido) {
		this.pedido = pedido;
	}

}
