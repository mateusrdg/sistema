package com.mateus.sistema.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.mateus.sistema.domain.PedidoItem;
import com.mateus.sistema.domain.Preco;
import com.mateus.sistema.domain.Produto;
import com.mateus.sistema.domain.ProdutoEstoque;
import com.mateus.sistema.domain.ProdutoSubgrupo;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String descricao;
	private Calendar dataCadastro;
	private Boolean ativo;

	private List<PrecoDTO> precos = new ArrayList<PrecoDTO>();

	private List<ProdutoEstoqueDTO> estoques = new ArrayList<ProdutoEstoqueDTO>();

	private List<ProdutoSubgrupoDTO> subgrupos = new ArrayList<ProdutoSubgrupoDTO>();

	public ProdutoDTO() {
	}

	public ProdutoDTO(Integer id, String descricao, Calendar dataCadastro, Boolean ativo, List<PrecoDTO> precos,
			List<ProdutoEstoqueDTO> estoques, List<ProdutoSubgrupoDTO> subgrupos, List<PedidoItem> itens) {
		this.id = id;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
		this.ativo = ativo;
		this.precos = precos;
		this.estoques = estoques;
		this.subgrupos = subgrupos;
	}

	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.dataCadastro = produto.getDataCadastro();
		this.ativo = produto.getAtivo();

		// this.precos = produto.getPrecos().map(obj -> new PrecoDTO(obj));

		for (Preco preco : produto.getPrecos()) {
			this.precos.addAll(Arrays.asList(new PrecoDTO(preco)));
		}

		for (ProdutoEstoque produtoEstoque : produto.getProdutoEstoque()) {
			this.estoques.addAll(Arrays.asList(new ProdutoEstoqueDTO(produtoEstoque)));
		}

		for (ProdutoSubgrupo produtoSubgrupo : produto.getProdutoSubgrupo()) {
			this.subgrupos.addAll(Arrays.asList(new ProdutoSubgrupoDTO(produtoSubgrupo.getSubgrupo())));
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<PrecoDTO> getPrecos() {
		return precos;
	}

	public void setPrecos(List<PrecoDTO> precos) {
		this.precos = precos;
	}

	public List<ProdutoEstoqueDTO> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<ProdutoEstoqueDTO> estoques) {
		this.estoques = estoques;
	}

	public List<ProdutoSubgrupoDTO> getSubgrupos() {
		return subgrupos;
	}

	public void setSubgrupos(List<ProdutoSubgrupoDTO> subgrupos) {
		this.subgrupos = subgrupos;
	}

}
