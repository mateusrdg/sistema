package com.mateus.sistema.domain;

import java.io.Serializable;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mateus.sistema.domain.enums.TipoPessoa;
@Entity
@Table(name = "fornecedor")
//@SequenceGenerator(name = "id", sequenceName = "fornecedor_id_seq", allocationSize = 1)
public class Fornecedor extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nomeFantasia;

	public Fornecedor() {
	}

	public Fornecedor(Integer id, String nome, String email, Calendar dataCadastro, String cpfCnpj, String nomeFantasia) {
		super(id, TipoPessoa.FORNECEDOR,nome, email, dataCadastro, cpfCnpj);
		this.setNomeFantasia(nomeFantasia);
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}
