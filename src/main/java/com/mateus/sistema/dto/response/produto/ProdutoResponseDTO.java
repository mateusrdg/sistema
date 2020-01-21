package com.mateus.sistema.dto.response.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.dto.produto.BaseProdutoDTO;
import com.mateus.sistema.dto.produto.estoque.ProdutoEstoqueDTO;
import com.mateus.sistema.dto.produto.preco.PrecoDTO;
import com.mateus.sistema.dto.produto.subgrupo.SubgrupoDTO;

public class ProdutoResponseDTO extends BaseProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Calendar dataCadastro;
	private Boolean ativo;

	private List<PrecoDTO> precos = new ArrayList<PrecoDTO>();

	private List<ProdutoEstoqueDTO> estoques = new ArrayList<ProdutoEstoqueDTO>();

	private List<SubgrupoDTO> subgrupos = new ArrayList<SubgrupoDTO>();

	public ProdutoResponseDTO() {
	}

	public ProdutoResponseDTO(Produto produto) {
		super(produto);
		this.dataCadastro = produto.getDataCadastro();
		this.ativo = produto.getAtivo();

		precos = produto.getPrecos().stream().map(obj -> new PrecoDTO(obj)).collect(Collectors.toList());
		estoques = produto.getProdutoEstoques().stream().map(obj -> new ProdutoEstoqueDTO(obj))
				.collect(Collectors.toList());
		subgrupos = produto.getProdutoSubgrupos().stream().map(obj -> new SubgrupoDTO(obj))
				.collect(Collectors.toList());
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

	public List<SubgrupoDTO> getSubgrupos() {
		return subgrupos;
	}

	public void setSubgrupos(List<SubgrupoDTO> subgrupos) {
		this.subgrupos = subgrupos;
	}

}
