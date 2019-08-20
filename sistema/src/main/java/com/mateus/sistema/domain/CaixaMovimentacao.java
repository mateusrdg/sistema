package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CaixaMovimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer estado;
	private Calendar dataAbertura;
	private Calendar horaAbertura;
	private Calendar dataFechamento;
	private Calendar horaFechamento;
	private Caixa caixa;
	private Funcionario funcionario;

	private List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

	public CaixaMovimentacao() {
	}

	public CaixaMovimentacao(Integer id, Integer estado, Calendar dataAbertura, Calendar horaAbertura,
			Calendar dataFechamento, Calendar horaFechamento, Caixa caixa, Funcionario funcionario) {
		super();
		this.id = id;
		this.estado = estado;
		this.dataAbertura = dataAbertura;
		this.horaAbertura = horaAbertura;
		this.dataFechamento = dataFechamento;
		this.horaFechamento = horaFechamento;
		this.caixa = caixa;
		this.funcionario = funcionario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Calendar getHoraAbertura() {
		return horaAbertura;
	}

	public void setHoraAbertura(Calendar horaAbertura) {
		this.horaAbertura = horaAbertura;
	}

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Calendar getHoraFechamento() {
		return horaFechamento;
	}

	public void setHoraFechamento(Calendar horaFechamento) {
		this.horaFechamento = horaFechamento;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		CaixaMovimentacao other = (CaixaMovimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
