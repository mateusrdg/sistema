package com.mateus.sistema.domain.pedido;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.mateus.sistema.domain.produto.Produto;

@MappedSuperclass
public abstract class PedidoItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal quantidade;
	private BigDecimal preco;
	private BigDecimal total;
	
	@Column(name = "desconto", precision = 19, scale = 4)
	private BigDecimal desconto;

	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;
	
	
	public PedidoItem() {
	}

	public PedidoItem(Long id, BigDecimal quantidade, BigDecimal desconto, Produto produto) {
		this.id = id;
		this.quantidade = quantidade;
		this.preco = produto.getValorPrecoPadrao();
		this.desconto = desconto;
		this.produto = produto;
		this.total = calculaTotal();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	private BigDecimal calculaTotal() {
		return (this.preco.multiply(this.quantidade).subtract(this.desconto));
	}
	
//	@PrePersist
//	private void prePersist () {
//		this.preco = produto.getValorPrecoPadrao();
//		this.total = calculaTotal();	
//	}
	
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
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
