package com.mateus.sistema.domain.pedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.mateus.sistema.domain.pessoa.Pessoa;
@MappedSuperclass
public abstract class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Calendar data;
	private Boolean ativo;
	private Calendar dataAlteracao;
	
	public Pedido() {
	}

	public Pedido(Long id) {
		this.id = id;
	}

	public abstract Pessoa getCompradorVendedor();
	
	public abstract Pessoa getClienteFornecedor();
	
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
	
	public Calendar getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Calendar dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	
	public BigDecimal getValorTotal() {
		return calculaValorTotal();
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	public abstract BigDecimal calculaValorTotal();

	public abstract BigDecimal getValorTotalFormasPagamento();
	
	@PrePersist
	public void prePresist() {
		this.data = Calendar.getInstance();
		this.ativo = true;
	}
	@PreUpdate
	public void preUpdate() {
		this.dataAlteracao = Calendar.getInstance();
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
