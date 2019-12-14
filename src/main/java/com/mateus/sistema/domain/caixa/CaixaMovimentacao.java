package com.mateus.sistema.domain.caixa;

import java.io.Serializable;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.mateus.sistema.domain.enums.EstadoCaixa;
import com.mateus.sistema.domain.pessoa.Funcionario;

@Entity(name = "CaixaMovimentacao")
@Table(name = "caixa_movimentacao")
public class CaixaMovimentacao implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_abertura")
	private Calendar dataAbertura;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_fechamento")
	private Calendar dataFechamento;

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

	public CaixaMovimentacao(Long id, EstadoCaixa estado, Calendar dataFechamento,
			Caixa caixa, Funcionario funcionario) {
		super();
		this.id = id;
		this.estado = (estado == null) ? null : estado.getCod();
		this.dataFechamento = dataFechamento;
		this.caixa = caixa;
		this.funcionario = funcionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
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

	@PrePersist
	public void PrePersist () {
		this.dataAbertura = Calendar.getInstance();
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
