package com.mateus.sistema.domain.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.pedido.PedidoItem;

@Entity(name = "Produto")
public class Produto implements Serializable {
	@Version
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String referencia;
	private Calendar dataCadastro;
	private Boolean ativo;

	@OneToMany(mappedBy = "produto", cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<Preco> precos = new ArrayList<Preco>();

	@OneToMany(mappedBy = "produto", cascade ={CascadeType.REMOVE})
	private List<ProdutoEstoque> produtoEstoques = new ArrayList<ProdutoEstoque>();
	
	@OneToMany(mappedBy = "produto", cascade ={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
	private List<ProdutoSubgrupo> produtoSubgrupos = new ArrayList<ProdutoSubgrupo>();
	
	@JsonIgnore
	@Transient
	private List<PedidoItem> itens = new ArrayList<PedidoItem>();

	public Produto() {
	}

	public Produto(Long id) {
		this.id = id;
	}
	
	public Produto(Long id, String descricao, String referencia) {
		this.id = id;
		this.descricao = descricao;
		this.referencia = referencia;
	}
	
//	public Produto(Long id, String descricao, String referencia, Calendar dataCadastro, Boolean ativo) {
//		this.id = id;
//		this.descricao = descricao;
//		this.referencia = referencia;
//		this.dataCadastro = dataCadastro;
//		this.ativo = ativo;
//	}

	public BigDecimal getValorPrecoPadrao() {
		//TODO
		//fiz isso aqui só pra testar.
		BigDecimal valor = null;
		if (precos.isEmpty() == false) {
			for (Preco preco : precos) {
				if (preco.getTipo() == TipoPreco.AVISTA) {
					valor = preco.getValor();
				}
			}
		}
		if (valor == null) {
			valor = new BigDecimal(0);
		}
		return valor;
	}

	@PrePersist
    public void prePersist() {
        this.dataCadastro = Calendar.getInstance();
        this.ativo = true;
    }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<Preco> getPrecos() {
		return precos;
	}

	public void setPrecos(List<Preco> precos) {
		this.precos = precos;
	}

	public List<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(List<PedidoItem> itens) {
		this.itens = itens;
	}

	public List<ProdutoSubgrupo> getProdutoSubgrupos() {
		return produtoSubgrupos;
	}

	public List<ProdutoEstoque> getProdutoEstoques() {
		return produtoEstoques;
	}

	public void setProdutoEstoques(List<ProdutoEstoque> produtoEstoques) {
		this.produtoEstoques = produtoEstoques;
	}

	public void setProdutoSubgrupos(List<ProdutoSubgrupo> produtoSubgrupos) {
		this.produtoSubgrupos = produtoSubgrupos;
	}
	
	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
