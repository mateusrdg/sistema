package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class EstoqueProduto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EstoqueProdutoPK id = new EstoqueProdutoPK();
	private BigDecimal quantidade;
	
	public EstoqueProduto() {
	}

	public EstoqueProduto(Estoque estoque, Produto produto, BigDecimal quantidade) {
		this.id.setEstoque(estoque);
		this.id.setProduto(produto);
		this.quantidade = quantidade;
	}

	public EstoqueProdutoPK getId() {
		return id;
	}

	public void setId(EstoqueProdutoPK id) {
		this.id = id;
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
		EstoqueProduto other = (EstoqueProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
