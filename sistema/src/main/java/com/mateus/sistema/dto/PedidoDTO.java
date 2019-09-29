package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.Compra;
import com.mateus.sistema.domain.CompraItem;
import com.mateus.sistema.domain.FormaPagamentoCompra;
import com.mateus.sistema.domain.FormaPagamentoVenda;
import com.mateus.sistema.domain.Orcamento;
import com.mateus.sistema.domain.OrcamentoItem;
import com.mateus.sistema.domain.Pedido;
import com.mateus.sistema.domain.Venda;
import com.mateus.sistema.domain.VendaItem;

public class PedidoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Calendar data;
	private List<PedidoItemDTO> itens = new ArrayList<PedidoItemDTO>();
	private List<FormaPagamentoDTO> formasPagamento = new ArrayList<FormaPagamentoDTO>();

	public PedidoDTO() {
	}

	public PedidoDTO(Integer id, Calendar data, List<PedidoItemDTO> itens, List<FormaPagamentoDTO> formasPagamento) {
		this.id = id;
		this.data = data;
	}

	public PedidoDTO(Pedido pedido) {
		if (pedido instanceof Venda) {
			for (FormaPagamentoVenda formaPagamentoPedido : ((Venda) pedido).getFormasPagamento()) {
				this.formasPagamento.addAll(Arrays.asList(new FormaPagamentoDTO(formaPagamentoPedido)));
			}
			for (VendaItem item : ((Venda) pedido).getItens()) {
				this.itens.addAll(Arrays.asList(new PedidoItemDTO(item)));
			}
		}

		if (pedido instanceof Compra) {
			for (FormaPagamentoCompra formaPagamentoPedido : ((Compra) pedido).getFormasPagamento()) {
				this.formasPagamento.addAll(Arrays.asList(new FormaPagamentoDTO(formaPagamentoPedido)));
			}
			for (CompraItem item : ((Compra) pedido).getItens()) {
				this.itens.addAll(Arrays.asList(new PedidoItemDTO(item)));
			}
		}
		
		if (pedido instanceof Orcamento) {
			for (OrcamentoItem item : ((Orcamento) pedido).getItens()) {
				this.itens.addAll(Arrays.asList(new PedidoItemDTO(item)));
			}
		}
		this.id = pedido.getId();
		this.data = pedido.getData();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
