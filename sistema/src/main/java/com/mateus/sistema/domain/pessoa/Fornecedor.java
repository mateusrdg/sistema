package com.mateus.sistema.domain.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.pedido.Compra;

@Entity(name = "Fornecedor")
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nomeFantasia;

	@JsonIgnore
	@OneToMany(mappedBy = "fornecedor")
	private List<Compra> pedidosCompra = new ArrayList<Compra>();

	public Fornecedor() {
	}

	public Fornecedor(Long id, String nome, String email, String cpfCnpj,
			String nomeFantasia) {
		super(id, nome, email, cpfCnpj);
		this.setNomeFantasia(nomeFantasia);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public List<Compra> getPedidosCompra() {
		return pedidosCompra;
	}

	public void setPedidosCompra(List<Compra> pedidosCompra) {
		this.pedidosCompra = pedidosCompra;
	}

}
