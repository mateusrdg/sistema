package com.mateus.sistema.domain.pessoa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.enums.TipoFuncionario;
import com.mateus.sistema.domain.enums.TipoPessoa;
import com.mateus.sistema.domain.pedido.Compra;

@Entity(name = "Funcionario")
@Table(name = "funcionario")
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "tipo")
	private Integer tipoFuncionario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "funcionario")
	private List<Compra> pedidosCompra = new ArrayList<Compra>();

	public Funcionario() {
	}

	public Funcionario(Long id, String nome, String email, String cpfCnpj,
			TipoFuncionario tipoFuncionario) {
		super(id, nome, email, cpfCnpj);
		this.tipoFuncionario = (tipoFuncionario == null) ? null : tipoFuncionario.getCod();
	}

	public TipoFuncionario getTipoFuncionario() {
		return TipoFuncionario.toEnum(tipoFuncionario);
	}

	public void setTipo(TipoFuncionario tipo) {
		this.tipoFuncionario = tipo.getCod();
	}

	public List<Compra> getPedidosCompra() {
		return pedidosCompra;
	}

	public void setPedidosCompra(List<Compra> pedidosCompra) {
		this.pedidosCompra = pedidosCompra;
	}

	@Override
	public TipoPessoa getTipoPessoa() {
		return TipoPessoa.FUNCIONARIO;
	}	
	
}
