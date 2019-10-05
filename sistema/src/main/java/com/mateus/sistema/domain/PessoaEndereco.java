package com.mateus.sistema.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mateus.sistema.domain.enums.TipoPessoa;

@Entity(name = "PessoaEndereco")
@Table(name = "pessoa_endereco")
public class PessoaEndereco implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "pessoa_id")
	private Long pessoa;

	@ManyToOne(cascade  = CascadeType.REMOVE)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	private Integer tipo;

	public PessoaEndereco() {
	}

	public PessoaEndereco(Long id, Pessoa pessoa, Endereco endereco) {
		this.id = id;
		this.pessoa = pessoa.getId();
		if (pessoa instanceof Cliente) {
			this.tipo = TipoPessoa.CLIENTE.getCod();
		} else if (pessoa instanceof Funcionario) {
			this.tipo = TipoPessoa.FUNCIONARIO.getCod();
		} else if (pessoa instanceof Fornecedor) {
			this.tipo = TipoPessoa.FORNECEDOR.getCod();
		}
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoPessoa getTipo() {
		return TipoPessoa.toEnum(tipo);
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo.getCod();
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaEndereco other = (PessoaEndereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
