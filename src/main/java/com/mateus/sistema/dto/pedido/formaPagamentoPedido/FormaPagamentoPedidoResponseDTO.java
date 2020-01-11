package com.mateus.sistema.dto.pedido.formaPagamentoPedido;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.pedido.FormaPagamentoPedido;
import com.mateus.sistema.dto.pedido.ContaDTO;
import com.mateus.sistema.dto.pedido.FormaPagamentoDTO;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.parcela.ParcelaResponseDTO;

public class FormaPagamentoPedidoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private FormaPagamentoDTO formaPagamento;
	private BigDecimal valor;
	@JsonFormat(pattern ="HH:mm:ss dd/MM/yyyy")
	private Calendar data;
	private EstadoPagamento estado;

	private ContaDTO conta;
	List<ParcelaResponseDTO> parcelas = new ArrayList<ParcelaResponseDTO>();

	public FormaPagamentoPedidoResponseDTO() {

	}

	public FormaPagamentoPedidoResponseDTO(FormaPagamentoPedido formaPagamentoPedido) {
		this.id = formaPagamentoPedido.getId();
		
		parcelas = (formaPagamentoPedido).getParcelas().stream().map(obj -> new ParcelaResponseDTO(obj))
				.collect(Collectors.toList());
		if ((formaPagamentoPedido).getConta() != null) {
			setConta(new ContaDTO((formaPagamentoPedido).getConta()));
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

	public List<ParcelaResponseDTO> getParcelas() {
		return parcelas;
	}

	public void setParcelas(List<ParcelaResponseDTO> parcelas) {
		this.parcelas = parcelas;
	}

	public ContaDTO getConta() {
		return conta;
	}

	public void setConta(ContaDTO conta) {
		this.conta = conta;
	}

}
