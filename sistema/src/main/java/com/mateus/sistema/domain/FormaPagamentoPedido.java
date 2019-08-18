package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.enums.EstadoPagamento;

public class FormaPagamentoPedido implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Pedido pedido;
	private FormaPagamento formaPagamento;

	private Calendar data;
	private BigDecimal valor;
	private Integer estado;
	private List<Parcela> parcelas = new ArrayList<Parcela>();

	public FormaPagamentoPedido() {
	}

	public FormaPagamentoPedido(Integer id, Pedido pedido, FormaPagamento formaPagamento, Calendar data,
			BigDecimal valor, EstadoPagamento estado) {
		this.id = id;
		this.pedido = pedido;
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

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
