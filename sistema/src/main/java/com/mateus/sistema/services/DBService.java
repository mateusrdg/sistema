package com.mateus.sistema.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.Cidade;
import com.mateus.sistema.domain.Endereco;
import com.mateus.sistema.domain.Estado;
import com.mateus.sistema.domain.Estoque;
import com.mateus.sistema.domain.ProdutoEstoque;
import com.mateus.sistema.domain.Grupo;
import com.mateus.sistema.domain.Pais;
import com.mateus.sistema.domain.Preco;
import com.mateus.sistema.domain.Produto;
import com.mateus.sistema.domain.Subgrupo;
import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.repository.CidadeRepository;
import com.mateus.sistema.repository.EnderecoRepository;
import com.mateus.sistema.repository.EstadoRepository;
import com.mateus.sistema.repository.EstoqueProdutoRepository;
import com.mateus.sistema.repository.EstoqueRepository;
import com.mateus.sistema.repository.GrupoRepository;
import com.mateus.sistema.repository.PaisRepository;
import com.mateus.sistema.repository.PrecoRepository;
import com.mateus.sistema.repository.ProdutoRepository;
import com.mateus.sistema.repository.SubgrupoRepository;

@Service
public class DBService {
	@Autowired
	private PaisRepository paisRepo;
	@Autowired 
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	@Autowired 
	private EnderecoRepository enderecoRepo;
	@Autowired
	private GrupoRepository grupoRepo;
	@Autowired
	private SubgrupoRepository subgrupoRepo;
	@Autowired
	private EstoqueRepository estoqueRepo;
	@Autowired
	private ProdutoRepository produtoRepo;
	@Autowired
	private PrecoRepository precoRepo;
	@Autowired
	private EstoqueProdutoRepository estoqueProdutoRepo;
	
	public void instantiateTestDatabase() {
		Pais pais = new Pais(null, "Brasil", "10", "BR");
		paisRepo.saveAll(Arrays.asList(pais));
		
		Estado estado1 = new Estado(null, "Ceara", "11", "CE", pais);
		Estado estado2 = new Estado(null, "Pernanbuco", "12", "PE", pais);
		estadoRepo.saveAll(Arrays.asList(estado1, estado2));
				
		Cidade cidade1 = new Cidade(null, "Forataleza", "12345", estado1);
		Cidade cidade2 = new Cidade(null, "Sobral", "64548", estado1);
		Cidade cidade3 = new Cidade(null, "Recife", "32548", estado2);
		cidadeRepo.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Endereco endereco1 = new Endereco(null, "Gaspar Lemos", "275", "60440530", "casa", "Pici", cidade1);
		Endereco endereco2 = new Endereco(null, "Rua A", "111", "11111111", "casa", "Bairro A", cidade2);
		Endereco endereco3 = new Endereco(null, "Rua B", "222", "22222222", "apt", "Bairro B", cidade3);
		Endereco endereco4 = new Endereco(null, "Rua C", "333", "33333333", "", "Bairro C", cidade1);
		enderecoRepo.saveAll(Arrays.asList(endereco1, endereco2, endereco3, endereco4));
		
		Grupo grupo1 = new Grupo(null, "grupo1");
		Grupo grupo2 = new Grupo(null, "grupo2");
		grupoRepo.saveAll(Arrays.asList(grupo1,grupo2));
		
		Subgrupo subgrupo1 = new Subgrupo(null, "Subgrupo1", grupo1);
		Subgrupo subgrupo2 = new Subgrupo(null, "Subgrupo2", grupo2);
		Subgrupo subgrupo3 = new Subgrupo(null, "Subgrupo3", grupo1);
		subgrupoRepo.saveAll(Arrays.asList(subgrupo1,subgrupo2,subgrupo3));
		
		Estoque estoque1 = new Estoque(null, "Estoque1");
		Estoque estoque2 = new Estoque(null, "Estoque2");
		estoqueRepo.saveAll(Arrays.asList(estoque1,estoque2));
		
		Produto produto1 = new Produto(null, "produto1", Calendar.getInstance(), true);
		Produto produto2 = new Produto(null, "produto2", Calendar.getInstance(), true);
		Produto produto3 = new Produto(null, "produto3", Calendar.getInstance(), true);
		Produto produto4 = new Produto(null, "produto4", Calendar.getInstance(), true);
		
		
		Preco preco1 = new Preco(null, produto1, new BigDecimal(100.00), TipoPreco.AVISTA);
		Preco preco2 = new Preco(null, produto2, new BigDecimal(200.00), TipoPreco.AVISTA);
		Preco preco3 = new Preco(null, produto3, new BigDecimal(300.00), TipoPreco.AVISTA);
		Preco preco4 = new Preco(null, produto4, new BigDecimal(400.00), TipoPreco.AVISTA);
		Preco preco5 = new Preco(null, produto1, new BigDecimal(500.00), TipoPreco.APRAZO);
		
		produto1.getPrecos().addAll(Arrays.asList(preco1,preco5));
		produto2.getPrecos().addAll(Arrays.asList(preco2));
		produto3.getPrecos().addAll(Arrays.asList(preco3));
		produto4.getPrecos().addAll(Arrays.asList(preco4));
		
		produtoRepo.saveAll(Arrays.asList(produto1,produto2,produto3,produto4));
		
		precoRepo.saveAll(Arrays.asList(preco1,preco2,preco3,preco4,preco5));
		
		ProdutoEstoque estoqueProduto1 = new ProdutoEstoque(null, estoque1, produto1, new BigDecimal(5));
		ProdutoEstoque estoqueProduto2 = new ProdutoEstoque(null, estoque2, produto1, new BigDecimal(10));
		ProdutoEstoque estoqueProduto3 = new ProdutoEstoque(null, estoque1, produto2, new BigDecimal(15));
		ProdutoEstoque estoqueProduto4 = new ProdutoEstoque(null, estoque1, produto3, new BigDecimal(25));
		ProdutoEstoque estoqueProduto5 = new ProdutoEstoque(null, estoque1, produto4, new BigDecimal(35));
		
		estoqueProdutoRepo.saveAll(Arrays.asList(estoqueProduto1,estoqueProduto2,estoqueProduto3,estoqueProduto3,estoqueProduto4,estoqueProduto5));
	}
}
