package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.CaixaMovimentacao;
import com.mateus.sistema.domain.Movimentacao;
import com.mateus.sistema.domain.enums.EstadoCaixa;

public class CaixaMovimentacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private EstadoCaixa estado;

	private String caixa;

	private Calendar dataAbertura;

	private Calendar dataFechamento;

	private FuncionarioDTO funcionario;

	private List<MovimentacaoDTO> movimentacoes = new ArrayList<MovimentacaoDTO>();
	
	public CaixaMovimentacaoDTO() {
	}

	public CaixaMovimentacaoDTO(Long id, EstadoCaixa estado, String caixa, Calendar dataAbertura,
			Calendar dataFechamento, FuncionarioDTO funcionario, List<MovimentacaoDTO> movimentacoes) {
		this.id = id;
		this.estado = estado;
		this.caixa = caixa;
		this.dataAbertura = dataAbertura;
		this.dataFechamento = dataFechamento;
		this.funcionario = funcionario;
		this.movimentacoes = movimentacoes;
	}

	public CaixaMovimentacaoDTO(CaixaMovimentacao caixaMovimentacao) {
		this.id = caixaMovimentacao.getId();
		this.estado = caixaMovimentacao.getEstado();
		this.caixa = caixaMovimentacao.getCaixa().getDescricao();
		this.dataAbertura = caixaMovimentacao.getDataAbertura();
		this.dataFechamento = caixaMovimentacao.getDataAbertura();
		this.funcionario = new FuncionarioDTO(caixaMovimentacao.getFuncionario());
		for (Movimentacao movimentacao : caixaMovimentacao.getMovimentacoes()) {
			this.movimentacoes.addAll(Arrays.asList(new MovimentacaoDTO(movimentacao) ));
		}
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado.getDescricao();
	}

	public void setEstado(EstadoCaixa estado) {
		this.estado = estado;
	}

	public String getCaixa() {
		return caixa;
	}

	public void setCaixa(String caixa) {
		this.caixa = caixa;
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

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public List<MovimentacaoDTO> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(List<MovimentacaoDTO> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

}
