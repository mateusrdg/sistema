package com.mateus.sistema.dto.pedido.formaPagamentoPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.dto.pedido.FormaPagamentoIdDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaNewDTO;

public class FormaPagamentoPedidoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Valid
	@NotNull(message = "Preenchimento obrigatório")
	private FormaPagamentoIdDTO formaPagamento;
	@NotNull(message = "Preenchimento obrigatório.")
	private BigDecimal valor;
	private Calendar data;
	@NotNull(message = "Preenchimento obrigatório.")
	private EstadoPagamento estado;
	@Valid
	@NotNull(message = "Preenchimento obrigatório")
	private List<ParcelaNewDTO> parcelas = new ArrayList<ParcelaNewDTO>();

	public FormaPagamentoPedidoNewDTO() {

	}

	public FormaPagamentoPedidoNewDTO(FormaPagamentoPedido formaPagamentoPedido) {
		this.formaPagamento = new FormaPagamentoIdDTO(formaPagamentoPedido.getFormaPagamento());
		this.valor = formaPagamentoPedido.getValor();
		this.data = formaPagamentoPedido.getData();
		this.estado = formaPagamentoPedido.getEstado();
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

	public EstadoPagamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}

	public List<ParcelaNewDTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaNewDTO> parcelas) {
		this.parcelas = parcelas;
	}
	
	public BigDecimal getValorTotalParcelas() {
		return parcelas.stream().map(x -> x.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);
	}

}
