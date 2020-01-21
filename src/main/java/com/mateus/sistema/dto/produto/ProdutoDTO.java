package com.mateus.sistema.dto.produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.mateus.sistema.dto.produto.estoque.EstoqueIdDTO;
import com.mateus.sistema.dto.produto.preco.PrecoNewDTO;
import com.mateus.sistema.dto.produto.subgrupo.SubgrupoIdDTO;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	@NotEmpty(message = "Preenchimento obrigatório.")
	@Length(min = 5, max = 200, message = "O tamanho deve ser entre 5 e 200 caracteres")
	private String descricao;
	@NotEmpty(message = "Preenchimento obrigatório.")
	private String referencia;
	
	private List<PrecoNewDTO> precos = new ArrayList<PrecoNewDTO>();
	private List<EstoqueIdDTO> estoques = new ArrayList<EstoqueIdDTO>();
	private List<SubgrupoIdDTO> subgrupos = new ArrayList<SubgrupoIdDTO>();

	
	public ProdutoDTO() {
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public List<PrecoNewDTO> getPrecos() {
		return precos;
	}

	public void setPrecos(List<PrecoNewDTO> precos) {
		this.precos = precos;
	}

	public List<EstoqueIdDTO> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<EstoqueIdDTO> estoques) {
		this.estoques = estoques;
	}

	public List<SubgrupoIdDTO> getSubgrupos() {
		return subgrupos;
	}

	public void setSubgrupos(List<SubgrupoIdDTO> subgrupos) {
		this.subgrupos = subgrupos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
