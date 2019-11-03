package com.mateus.sistema.domain.pedido;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.produto.Produto;

@Entity(name = "OrcamentoItem")
@Table(name = "orcamento_item")
public class OrcamentoItem extends PedidoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "orcamento_id")
	private Orcamento pedido;

	public OrcamentoItem() {
	}

	public OrcamentoItem(Long id, Orcamento pedido, Produto produto, BigDecimal quantidade, BigDecimal preco,
			BigDecimal desconto) {
		super(id, quantidade, preco, desconto, produto);
		this.pedido = pedido;
	}
	@JsonIgnore
	public Orcamento getOrcamento() {
		return pedido;
	}

	public void setOrcamento(Orcamento pedido) {
		this.pedido = pedido;
	}
}
