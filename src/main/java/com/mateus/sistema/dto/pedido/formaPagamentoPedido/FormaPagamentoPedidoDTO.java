package com.mateus.sistema.dto.pedido.formaPagamentoPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.dto.pedido.FormaPagamentoIdDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaDTO;

public class FormaPagamentoPedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	@Valid
	@NotNull(message = "Preenchimento obrigatório")
	private FormaPagamentoIdDTO formaPagamento;
	@NotNull(message = "Preenchimento obrigatório.")
	private BigDecimal valor;
	private Calendar data;
	@Valid
	@NotNull(message = "Preenchimento obrigatório")
	private List<ParcelaDTO> parcelas = new ArrayList<ParcelaDTO>();

	public FormaPagamentoPedidoDTO() {

	}

	public FormaPagamentoPedidoDTO(FormaPagamentoPedido formaPagamentoPedido) {
		this.formaPagamento = new FormaPagamentoIdDTO(formaPagamentoPedido.getFormaPagamento());
		this.valor = formaPagamentoPedido.getValor();
		this.data = formaPagamentoPedido.getData();
	}

	public FormaPagamentoIdDTO getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoIdDTO formaPagamento) {
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

	public List<ParcelaDTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaDTO> parcelas) {
		this.parcelas = parcelas;
	}
	
	public BigDecimal getValorTotalParcelas() {
		return parcelas.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
