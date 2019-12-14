package com.mateus.sistema.domain.pessoa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mateus.sistema.domain.enums.TipoCliente;
import com.mateus.sistema.domain.enums.TipoPessoa;

@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "tipo")
	private Integer tipoCliente;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String email, String cpfCnpj, TipoCliente tipo) {
		super(id, nome, email, cpfCnpj);
		this.tipoCliente = (tipo == null) ? null : tipo.getCod();
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipoCliente = tipo.getCod();
	}

	@Override
	public TipoPessoa getTipoPessoa() {
		return TipoPessoa.CLIENTE;
	}

}
