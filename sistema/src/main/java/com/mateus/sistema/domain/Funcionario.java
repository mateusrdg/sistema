package com.mateus.sistema.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mateus.sistema.domain.enums.TipoFuncionario;
import com.mateus.sistema.domain.enums.TipoPessoa;
@Entity
@Table(name = "funcionario")
//@SequenceGenerator(name = "id", sequenceName = "funcionario_id_seq", allocationSize = 1)
public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "tipo")
	private Integer tipoFuncionario;
	
	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String email, Calendar dataCadastro, String cpfCnpj, TipoFuncionario tipoFuncionario) {
		super(id, TipoPessoa.FUNCIONARIO, nome, email, dataCadastro, cpfCnpj);
		this.tipoFuncionario = (tipoFuncionario == null) ? null : tipoFuncionario.getCod(); 
	}

	public TipoFuncionario getTipoFuncionario() {
		return TipoFuncionario.toEnum(tipoFuncionario);
	}

	public void setTipo(TipoFuncionario tipo) {
		this.tipoFuncionario = tipo.getCod();
	}
	
}
