package com.mateus.sistema.dto.pedido.formaPagamentoPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.dto.pedido.ContaNewDTO;
import com.mateus.sistema.dto.pedido.FormaPagamentoDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaNewDTO;

public class FormaPagamentoPedidoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private FormaPagamentoDTO formaPagamento;
	private BigDecimal valor;
	private Calendar data;
	private EstadoPagamento estado;

	private ContaNewDTO conta;
	List<ParcelaNewDTO> parcelas = new ArrayList<ParcelaNewDTO>();
	

	public FormaPagamentoPedidoNewDTO() {

	}

	public FormaPagamentoPedidoNewDTO(FormaPagamentoDTO formaPagamento, BigDecimal valor, Calendar data,
			EstadoPagamento estado, List<ParcelaNewDTO> parcelas, ContaNewDTO conta) {
		this.formaPagamento = formaPagamento;
		this.valor = valor;
		this.data = data;
		this.estado = estado;
		this.parcelas = parcelas;
		this.setConta(conta);
	}

	public FormaPagamentoPedidoNewDTO(FormaPagamentoPedido formaPagamentoPedido) {
		if (formaPagamentoPedido instanceof FormaPagamentoVenda) {
			parcelas = ((FormaPagamentoVenda) formaPagamentoPedido).getParcelas().stream().map(obj -> new ParcelaNewDTO(obj))
					.collect(Collectors.toList());
			setConta(new ContaNewDTO(((FormaPagamentoVenda) formaPagamentoPedido).getContaReceber())); 
		}
		
		if (formaPagamentoPedido instanceof FormaPagamentoCompra) {
			parcelas = ((FormaPagamentoCompra) formaPagamentoPedido).getParcelas().stream().map(obj -> new ParcelaNewDTO(obj))
					.collect(Collectors.toList());
			setConta(new ContaNewDTO(((FormaPagamentoCompra) formaPagamentoPedido).getContaPagar())); 
		}
		this.formaPagamento = new FormaPagamentoDTO(formaPagamentoPedido.getFormaPagamento());
		this.valor = formaPagamentoPedido.getValor();
		this.data = formaPagamentoPedido.getData();
		this.estado = formaPagamentoPedido.getEstado();
		
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

	public List<ParcelaNewDTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaNewDTO> parcelas) {
		this.parcelas = parcelas;
	}

	public ContaNewDTO getConta() {
		return conta;
	}

	public void setConta(ContaNewDTO conta) {
		this.conta = conta;
	}

}
