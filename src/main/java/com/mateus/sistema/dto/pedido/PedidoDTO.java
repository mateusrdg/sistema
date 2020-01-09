package com.mateus.sistema.dto.pedido;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.Pedido;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.dto.pedido.formaPagamentoPedido.FormaPagamentoPedidoDTO;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(pattern ="HH:mm:ss dd/MM/yyyy")
	private Calendar data;
	private List<FormaPagamentoPedidoDTO> formasPagamento = new ArrayList<FormaPagamentoPedidoDTO>();
	
	
	public PedidoDTO() {
	}

	public PedidoDTO(Pedido pedido) {
		if (pedido instanceof Venda) {
			formasPagamento = ((Venda) pedido).getFormasPagamento().stream().map(obj -> new FormaPagamentoPedidoDTO(obj))
					.collect(Collectors.toList());
		}

		if (pedido instanceof Compra) {
			formasPagamento = ((Compra) pedido).getFormasPagamento().stream().map(obj -> new FormaPagamentoPedidoDTO(obj))
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

	public List<FormaPagamentoPedidoDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoPedidoDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

}
