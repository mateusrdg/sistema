package com.mateus.sistema.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.FormaPagamento;
import com.mateus.sistema.domain.FormaPagamentoVenda;
import com.mateus.sistema.domain.ParcelaVenda;
import com.mateus.sistema.domain.enums.EstadoPagamento;

public class FormaPagamentoVendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String formaPagamento;
	private BigDecimal valor;
	private Calendar data;
	private EstadoPagamento estado;

	List<ParcelaDTO> parcelas = new ArrayList<ParcelaDTO>();

	public FormaPagamentoVendaDTO() {

	}

	public FormaPagamentoVendaDTO(FormaPagamento formaPagamento, BigDecimal valor, Calendar data,
			EstadoPagamento estado, List<ParcelaDTO> parcelas) {
		this.formaPagamento = formaPagamento.getDescricao();
		this.valor = valor;
		this.data = data;
		this.estado = estado;
		this.parcelas = parcelas;
	}

	public FormaPagamentoVendaDTO(FormaPagamentoVenda formaPagamentoPedido) {
		this.formaPagamento = formaPagamentoPedido.getFormaPagamento().getDescricao();
		this.valor = formaPagamentoPedido.getValor();
		this.data = formaPagamentoPedido.getData();
		this.estado = formaPagamentoPedido.getEstado();
		for (ParcelaVenda parcela : formaPagamentoPedido.getParcelas()) {
			this.parcelas.addAll(Arrays.asList(new ParcelaDTO(parcela)));
		}
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getEstado() {
		return estado.getDescricao();
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}

	public List<ParcelaDTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaDTO> parcelas) {
		this.parcelas = parcelas;
	}

}
