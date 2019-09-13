package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mateus.sistema.domain.enums.EstadoCaixa;

@Entity(name = "CaixaMovimentacao")
@Table(name = "caixa_movimentacao")
public class CaixaMovimentacao implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer estado;
	private Calendar dataAbertura;
	private Calendar horaAbertura;
	private Calendar dataFechamento;
	private Calendar horaFechamento;
	@ManyToOne
	@JoinColumn(name = "caixa_id")
	private Caixa caixa;
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	@OneToMany(mappedBy = "caixaMovimentacao")
	private List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();

	public CaixaMovimentacao() {
	}

	public CaixaMovimentacao(Integer id, EstadoCaixa estado, Calendar dataAbertura, Calendar horaAbertura,
			Calendar dataFechamento, Calendar horaFechamento, Caixa caixa, Funcionario funcionario) {
		super();
		this.id = id;
		this.estado = (estado == null) ? null : estado.getCod();;
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

	public EstadoCaixa getEstado() {
		return EstadoCaixa.toEnum(estado);
	}

	public void setEstado(EstadoCaixa estado) {
		this.estado = estado.getCod();
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
