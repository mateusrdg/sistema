package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.enums.TipoPedido;

@Entity
@Table(name = "forma_pagamento_pedido")
public class FormaPagamentoPedido implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "pedido_id")
	private Integer pedidoId;

	@Column(name = "tipo_pedido")
	private Integer tipoPedido;

	@ManyToOne
	@JoinColumn(name = "forma_pagamento_id")
	private FormaPagamento formaPagamento;

	private Calendar data;
	private BigDecimal valor;
	@Column(name = "estado")
	private Integer estado;
	
	@OneToMany(mappedBy = "formaPagamentoPedido")
	private List<Parcela> parcelas = new ArrayList<Parcela>();
	
	@OneToOne(mappedBy = "formaPagamentoPedido")
	private ContaPagar conta;

	public FormaPagamentoPedido() {
	}

	public FormaPagamentoPedido(Integer id, Pedido pedido, TipoPedido tipo, FormaPagamento formaPagamento,
			Calendar data, BigDecimal valor, EstadoPagamento estado) {
		this.id = id;
		this.pedidoId = pedido.getId();
		this.tipoPedido = (tipo == null) ? null : tipo.getCod();
		this.formaPagamento = formaPagamento;
		this.data = data;
		this.valor = valor;
		this.estado = (estado == null) ? null : estado.getCod();
		;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoPedido getPedido() {
		return TipoPedido.toEnum(tipoPedido);
	}

	public void setPedido(TipoPedido tipo) {
		this.tipoPedido = tipo.getCod();
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public List<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Pedido pedido) {
		this.pedidoId = pedido.getId();
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
		FormaPagamentoPedido other = (FormaPagamentoPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
