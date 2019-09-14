package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

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

	public Cliente(Integer id, String nome, String email, Calendar dataCadastro, String cpfCnpj, TipoCliente tipo) {
		super(id, TipoPessoa.CLIENTE, nome, email, dataCadastro, cpfCnpj);
		this.tipoCliente = tipo.getCod();
	}

	public TipoCliente getTipoCliente() {
		return TipoCliente.toEnum(tipoCliente);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipoCliente = tipo.getCod();
	}

}
