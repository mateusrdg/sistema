package com.mateus.sistema.dto.response.pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.Pedido;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.response.pedido.formaPagamentoPedido.FormaPagamentoPedidoResponseDTO;

public class PedidoResponseDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(pattern ="HH:mm:ss dd/MM/yyyy")
	private Calendar data;
	private List<FormaPagamentoPedidoResponseDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoResponseDTO>();
	
	
	public PedidoResponseDTO() {
	}

	public PedidoResponseDTO(Pedido pedido) {
		if (pedido instanceof Venda) {
			formasPagamento = ((Venda) pedido).getFormasPagamento().stream().map(obj -> new FormaPagamentoPedidoResponseDTO(obj))
					.collect(Collectors.toList());
		}

		if (pedido instanceof Compra) {
			formasPagamento = ((Compra) pedido).getFormasPagamento().stream().map(obj -> new FormaPagamentoPedidoResponseDTO(obj))
					.collect(Collectors.toList());
		}
		this.id = pedido.getId();
		this.data = pedido.getData();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<FormaPagamentoPedidoResponseDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoPedidoResponseDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

}
