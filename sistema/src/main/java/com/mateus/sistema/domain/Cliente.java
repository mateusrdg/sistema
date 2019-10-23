package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mateus.sistema.domain.enums.TipoCliente;

@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "tipo")
	private Integer tipoCliente;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String email, Calendar dataCadastro, String cpfCnpj, TipoCliente tipo) {
		super(id, nome, email, dataCadastro, cpfCnpj);
		this.tipoCliente = (tipo == null) ? null : tipo.getCod();
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipoCliente = tipo.getCod();
	}

}
