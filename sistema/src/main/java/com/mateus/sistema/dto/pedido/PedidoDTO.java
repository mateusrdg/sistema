package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.mateus.sistema.domain.Compra;
import com.mateus.sistema.domain.Orcamento;
import com.mateus.sistema.domain.Pedido;
import com.mateus.sistema.domain.Venda;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Calendar data;
	private List<PedidoItemDTO> itens = new ArrayList<PedidoItemDTO>();
	private List<FormaPagamentoDTO> formasPagamento = new ArrayList<FormaPagamentoDTO>();

	public PedidoDTO() {
	}

	public PedidoDTO(Long id, Calendar data, List<PedidoItemDTO> itens, List<FormaPagamentoDTO> formasPagamento) {
		this.id = id;
		this.data = data;
	}

	public PedidoDTO(Pedido pedido) {
		if (pedido instanceof Venda) {
			formasPagamento = ((Venda) pedido).getFormasPagamento().stream().map(obj -> new FormaPagamentoDTO(obj))
					.collect(Collectors.toList());
			itens = ((Venda) pedido).getItens().stream().map(obj -> new PedidoItemDTO(obj))
					.collect(Collectors.toList());
		}

		if (pedido instanceof Compra) {
			formasPagamento = ((Compra) pedido).getFormasPagamento().stream().map(obj -> new FormaPagamentoDTO(obj))
					.collect(Collectors.toList());
			itens = ((Compra) pedido).getItens().stream().map(obj -> new PedidoItemDTO(obj))
					.collect(Collectors.toList());
		}

		if (pedido instanceof Orcamento) {
			itens = ((Orcamento) pedido).getItens().stream().map(obj -> new PedidoItemDTO(obj))
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

	public List<PedidoItemDTO> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItemDTO> itens) {
		this.itens = itens;
	}

	public List<FormaPagamentoDTO> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamentoDTO> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

}
