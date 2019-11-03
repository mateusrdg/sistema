package com.mateus.sistema.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.enums.TipoConta;

@MappedSuperclass
public abstract class Conta implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Calendar data;
	private Calendar hora;
	private BigDecimal valor;
	private Integer estado;
	private Calendar dataPagamento;
	private Calendar dataVencimento;
	@Transient
	private Integer tipo;

	public Conta() {
	}

	public Conta(Long id, TipoConta tipo, Calendar data, Calendar hora, BigDecimal valor, EstadoPagamento estado,
			Calendar dataPagamento, Calendar dataVencimento) {
		super();
		this.id = id;
		this.tipo = (tipo == null) ? null : tipo.getCod();
		this.data = data;
		this.hora = hora;
		this.valor = valor;
		this.estado = (estado == null) ? null : estado.getCod();
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
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

	public Calendar getHora() {
		return hora;
	}

	public void setHora(Calendar hora) {
		this.hora = hora;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}

	public Calendar getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Calendar dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public TipoConta getTipo() {
		return TipoConta.toEnum(tipo);
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo.getCod();
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
		Conta other = (Conta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
