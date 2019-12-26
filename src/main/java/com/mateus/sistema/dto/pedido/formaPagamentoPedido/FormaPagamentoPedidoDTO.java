package com.mateus.sistema.dto.pedido.formaPagamentoPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.dto.pedido.ContaDTO;
import com.mateus.sistema.dto.pedido.FormaPagamentoDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaDTO;

public class FormaPagamentoPedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private FormaPagamentoDTO formaPagamento;
	private BigDecimal valor;
	@JsonFormat(pattern ="HH:mm:ss dd/MM/yyyy")
	private Calendar data;
	private EstadoPagamento estado;

	private ContaDTO conta;
	List<ParcelaDTO> parcelas = new ArrayList<ParcelaDTO>();

	public FormaPagamentoPedidoDTO() {

	}

	public FormaPagamentoPedidoDTO(FormaPagamentoPedido formaPagamentoPedido) {
		this.id = formaPagamentoPedido.getId();
		
		if (formaPagamentoPedido instanceof FormaPagamentoVenda) {
			parcelas = ((FormaPagamentoVenda) formaPagamentoPedido).getParcelas().stream().map(obj -> new ParcelaDTO(obj))
					.collect(Collectors.toList());
			if (((FormaPagamentoVenda) formaPagamentoPedido).getContaReceber() != null) {
				setConta(new ContaDTO(((FormaPagamentoVenda) formaPagamentoPedido).getContaReceber()));
			}
		}
		
		if (formaPagamentoPedido instanceof FormaPagamentoCompra) {
			parcelas = ((FormaPagamentoCompra) formaPagamentoPedido).getParcelas().stream().map(obj -> new ParcelaDTO(obj))
					.collect(Collectors.toList());
			if (((FormaPagamentoCompra) formaPagamentoPedido).getContaPagar() != null) {
				setConta(new ContaDTO(((FormaPagamentoCompra) formaPagamentoPedido).getContaPagar()));
			}
			
		}
		this.formaPagamento = new FormaPagamentoDTO(formaPagamentoPedido.getFormaPagamento());
		this.valor = formaPagamentoPedido.getValor();
		this.data = formaPagamentoPedido.getData();
		this.estado = formaPagamentoPedido.getEstado();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public FormaPagamentoDTO getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamentoDTO formaPagamento) {
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

	public List<ParcelaDTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaDTO> parcelas) {
		this.parcelas = parcelas;
	}

	public ContaDTO getConta() {
		return conta;
	}

	public void setConta(ContaDTO conta) {
		this.conta = conta;
	}

}
