package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.enums.TipoPessoa;

@Entity(name = "Fornecedor")
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeFantasia;

	@JsonIgnore
	@OneToMany(mappedBy = "fornecedor")
	private List<PedidoCompra> pedidosCompra = new ArrayList<PedidoCompra>();

	public Fornecedor() {
	}

	public Fornecedor(Integer id, String nome, String email, Calendar dataCadastro, String cpfCnpj,
			String nomeFantasia) {
		super(id, TipoPessoa.FORNECEDOR, nome, email, dataCadastro, cpfCnpj);
		this.setNomeFantasia(nomeFantasia);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public List<PedidoCompra> getPedidosCompra() {
		return pedidosCompra;
	}

	public void setPedidosCompra(List<PedidoCompra> pedidosCompra) {
		this.pedidosCompra = pedidosCompra;
	}

}
