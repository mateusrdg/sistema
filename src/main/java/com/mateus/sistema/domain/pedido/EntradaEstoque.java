package com.mateus.sistema.domain.pedido;

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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mateus.sistema.domain.produto.Estoque;

@Entity(name = "EntradaEstoque")
@Table(name = "entrada_estoque")
public class EntradaEstoque implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal quantidade;
	private Calendar data;
	@OneToOne
	@JoinColumn(name = "compra_item_id")
	private CompraItem item;
	@ManyToOne
	@JoinColumn(name = "estoque_id")
	private Estoque estoque;

	public EntradaEstoque() {
	}

	public EntradaEstoque(Long id, CompraItem item, Estoque estoque) {
		this.id = id;
		this.quantidade = item.getQuantidade();
		this.item = item;
		this.estoque = estoque;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}
	
	public CompraItem getItem() {
		return item;
	}

	public void setItem(CompraItem item) {
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

	@PrePersist
	public void prePersist() {
		this.data = Calendar.getInstance();
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
