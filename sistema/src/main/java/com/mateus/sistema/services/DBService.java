package com.mateus.sistema.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.caixa.Caixa;
import com.mateus.sistema.domain.caixa.CaixaMovimentacao;
import com.mateus.sistema.domain.caixa.Movimentacao;
import com.mateus.sistema.domain.enums.EstadoCaixa;
import com.mateus.sistema.domain.enums.EstadoPagamento;
import com.mateus.sistema.domain.enums.TipoCliente;
import com.mateus.sistema.domain.enums.TipoFormaPagamento;
import com.mateus.sistema.domain.enums.TipoFuncionario;
import com.mateus.sistema.domain.enums.TipoMovimentacao;
import com.mateus.sistema.domain.enums.TipoPreco;
import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.CompraItem;
import com.mateus.sistema.domain.pedido.ContaPagar;
import com.mateus.sistema.domain.pedido.ContaReceber;
import com.mateus.sistema.domain.pedido.EntradaEstoque;
import com.mateus.sistema.domain.pedido.FormaPagamento;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.Orcamento;
import com.mateus.sistema.domain.pedido.OrcamentoItem;
import com.mateus.sistema.domain.pedido.ParcelaCompra;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.domain.pedido.VendaItem;
import com.mateus.sistema.domain.pessoa.Cidade;
import com.mateus.sistema.domain.pessoa.Cliente;
import com.mateus.sistema.domain.pessoa.Endereco;
import com.mateus.sistema.domain.pessoa.Estado;
import com.mateus.sistema.domain.pessoa.Fornecedor;
import com.mateus.sistema.domain.pessoa.Funcionario;
import com.mateus.sistema.domain.pessoa.Pais;
import com.mateus.sistema.domain.pessoa.PessoaEndereco;
import com.mateus.sistema.domain.pessoa.PessoaTelefone;
import com.mateus.sistema.domain.pessoa.Telefone;
import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.Grupo;
import com.mateus.sistema.domain.produto.Preco;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoEstoque;
import com.mateus.sistema.domain.produto.ProdutoSubgrupo;
import com.mateus.sistema.domain.produto.Subgrupo;
import com.mateus.sistema.repository.caixa.CaixaMovimentacaoRepository;
import com.mateus.sistema.repository.caixa.CaixaRepository;
import com.mateus.sistema.repository.caixa.MovimentacaoRepository;
import com.mateus.sistema.repository.pedido.CompraRepository;
import com.mateus.sistema.repository.pedido.EntradaEstoqueRepository;
import com.mateus.sistema.repository.pedido.FormaPagamentoRepository;
import com.mateus.sistema.repository.pedido.OrcamentoRepository;
import com.mateus.sistema.repository.pedido.VendaRepository;
import com.mateus.sistema.repository.pessoa.CidadeRepository;
import com.mateus.sistema.repository.pessoa.ClienteRepository;
import com.mateus.sistema.repository.pessoa.EnderecoRepository;
import com.mateus.sistema.repository.pessoa.EstadoRepository;
import com.mateus.sistema.repository.pessoa.FornecedorRepository;
import com.mateus.sistema.repository.pessoa.FuncionarioRepository;
import com.mateus.sistema.repository.pessoa.PaisRepository;
import com.mateus.sistema.repository.pessoa.PessoaEnderecoRepository;
import com.mateus.sistema.repository.pessoa.PessoaTelefoneRepository;
import com.mateus.sistema.repository.pessoa.TelefoneRepository;
import com.mateus.sistema.repository.produto.EstoqueRepository;
import com.mateus.sistema.repository.produto.GrupoRepository;
import com.mateus.sistema.repository.produto.ProdutoRepository;
import com.mateus.sistema.repository.produto.SubgrupoRepository;

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
	private ClienteRepository clienteRepo;
	@Autowired
	private FornecedorRepository fornecedorRepo;
	@Autowired
	private FuncionarioRepository funcionarioRepo;
	@Autowired
	private PessoaEnderecoRepository pessoaEnderecoRepo;
	@Autowired
	private CompraRepository pedidoCompraRepo;
	@Autowired
	private VendaRepository pedidoVendaRepo;
	@Autowired
	private OrcamentoRepository orcamentoRepo;
	@Autowired
	private FormaPagamentoRepository formaPagamentoRepo;
	@Autowired
	private CaixaRepository caixaRepo;
	@Autowired
	private CaixaMovimentacaoRepository caixaMovimentacaoRepo;
	@Autowired
	private MovimentacaoRepository movimentacaoRepo;
	@Autowired
	private TelefoneRepository telefoneRepo;
	@Autowired
	private PessoaTelefoneRepository pessoaTelefoneRepo;
	@Autowired
	private EntradaEstoqueRepository entradaEstoqueRepo;
	
	

	public void instantiateTestDatabase() {

		Pais pais = new Pais(null, "Brasil", "10", "BR");
		paisRepo.saveAll(Arrays.asList(pais));

		Estado estado1 = new Estado(null, "Ceara", "11", "CE", pais);
		Estado estado2 = new Estado(null, "Pernanbuco", "12", "PE", pais);
		estadoRepo.saveAll(Arrays.asList(estado1, estado2));

		Cidade cidade1 = new Cidade(null, "Forataleza", "12345", estado1);
		Cidade cidade2 = new Cidade(null, "Sobral", "64548", estado1);
		Cidade cidade3 = new Cidade(null, "Recife", "32548", estado2);
		cidadeRepo.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

		Endereco endereco1 = new Endereco(null, "Gaspar Lemos", "275", "60440530", "casa", "Pici", cidade1);
		Endereco endereco2 = new Endereco(null, "Rua A", "111", "11111111", "casa", "Bairro A", cidade2);
		Endereco endereco3 = new Endereco(null, "Rua B", "222", "22222222", "apt", "Bairro B", cidade3);
		Endereco endereco4 = new Endereco(null, "Rua C", "333", "33333333", "", "Bairro C", cidade1);
		enderecoRepo.saveAll(Arrays.asList(endereco1, endereco2, endereco3, endereco4));

		Grupo grupo1 = new Grupo(null, "grupo1");
		Grupo grupo2 = new Grupo(null, "grupo2");
		grupoRepo.saveAll(Arrays.asList(grupo1, grupo2));

		Subgrupo subgrupo1 = new Subgrupo(null, "Subgrupo1", grupo1);
		Subgrupo subgrupo2 = new Subgrupo(null, "Subgrupo2", grupo2);
		Subgrupo subgrupo3 = new Subgrupo(null, "Subgrupo3", grupo1);
		Subgrupo subgrupo4 = new Subgrupo(null, "Eletrônicos", grupo1);
		subgrupoRepo.saveAll(Arrays.asList(subgrupo1, subgrupo2, subgrupo3, subgrupo4));

		Estoque estoque1 = new Estoque(null, "Estoque1");
		Estoque estoque2 = new Estoque(null, "Estoque2");
		Estoque estoque3 = new Estoque(null, "Galpão");
		estoqueRepo.saveAll(Arrays.asList(estoque1, estoque2, estoque3));

		Produto produto1 = new Produto(null, "produto1", "aaa");
		Produto produto2 = new Produto(null, "produto2", "bbb");
		Produto produto3 = new Produto(null, "produto3", "ccc");
		Produto produto4 = new Produto(null, "produto4", "ddd");

		ProdutoSubgrupo prodSubgrupo1 = new ProdutoSubgrupo(null, subgrupo1, produto1);
		ProdutoSubgrupo prodSubgrupo2 = new ProdutoSubgrupo(null, subgrupo2, produto1);
		ProdutoSubgrupo prodSubgrupo3 = new ProdutoSubgrupo(null, subgrupo1, produto2);
		ProdutoSubgrupo prodSubgrupo4 = new ProdutoSubgrupo(null, subgrupo3, produto4);

		produto1.setProdutoSubgrupos(Arrays.asList(prodSubgrupo1, prodSubgrupo2));
		produto2.setProdutoSubgrupos(Arrays.asList(prodSubgrupo3));
		produto4.setProdutoSubgrupos(Arrays.asList(prodSubgrupo4));

		Preco preco1 = new Preco(null, produto1, new BigDecimal(100.00), TipoPreco.AVISTA);
		Preco preco2 = new Preco(null, produto2, new BigDecimal(200.00), TipoPreco.AVISTA);
		Preco preco3 = new Preco(null, produto3, new BigDecimal(300.00), TipoPreco.AVISTA);
		Preco preco4 = new Preco(null, produto4, new BigDecimal(400.00), TipoPreco.AVISTA);
		Preco preco5 = new Preco(null, produto1, new BigDecimal(500.00), TipoPreco.APRAZO);

		produto1.setPrecos(Arrays.asList(preco1, preco5));
		produto2.getPrecos().addAll(Arrays.asList(preco2));
		produto3.getPrecos().addAll(Arrays.asList(preco3));
		produto4.getPrecos().addAll(Arrays.asList(preco4));

		ProdutoEstoque estoqueProduto1 = new ProdutoEstoque(null, estoque1, produto1, null);
		ProdutoEstoque estoqueProduto2 = new ProdutoEstoque(null, estoque2, produto1, null);
		ProdutoEstoque estoqueProduto3 = new ProdutoEstoque(null, estoque1, produto2, null);
		ProdutoEstoque estoqueProduto4 = new ProdutoEstoque(null, estoque1, produto3, null);
		ProdutoEstoque estoqueProduto5 = new ProdutoEstoque(null, estoque1, produto4, null);
		

		produto1.setProdutoEstoques(Arrays.asList(estoqueProduto1, estoqueProduto2));
		produto2.setProdutoEstoques(Arrays.asList(estoqueProduto3));
		produto3.setProdutoEstoques(Arrays.asList(estoqueProduto4));
		produto4.setProdutoEstoques(Arrays.asList(estoqueProduto5));

		produtoRepo.saveAll(Arrays.asList(produto1, produto2, produto3, produto4));

		Cliente cliente1 = new Cliente(null, "Mateus", "mateusrodrigues-cp@hotmail.com", Calendar.getInstance(),
				"60541329383", TipoCliente.PESSOAFISICA);
		Cliente cliente2 = new Cliente(null, "João", "joao@gmail.com", Calendar.getInstance(), "547465444",
				TipoCliente.PESSOAFISICA);
		Cliente cliente3 = new Cliente(null, "Maria", "maria@hotmail.com", Calendar.getInstance(), "326544477",
				TipoCliente.PESSOAJURIDICA);
		clienteRepo.saveAll(Arrays.asList(cliente1, cliente2, cliente3));

		Fornecedor fornecedor1 = new Fornecedor(null, "Nome Empresa", "empresa@empresa.com", Calendar.getInstance(),
				"326544477", "Nome fantasia");
		Fornecedor fornecedor2 = new Fornecedor(null, "Nome Empresa2", "empresa2@empresa2.com", Calendar.getInstance(),
				"21457487", "Nome fantasia2");
		Fornecedor fornecedor3 = new Fornecedor(null, "Nome Empresa3", "empresa3@empresa3.com", Calendar.getInstance(),
				"11111111111", "Nome fantasia3");
		fornecedorRepo.saveAll(Arrays.asList(fornecedor1, fornecedor2, fornecedor3));

		Funcionario funcionario1 = new Funcionario(null, "Berg", "berg@corre.com", Calendar.getInstance(), "548784554",
				TipoFuncionario.VENDEDOR);
		Funcionario funcionario2 = new Funcionario(null, "joana", "joana@gmail.com", Calendar.getInstance(),
				"545456444", TipoFuncionario.GERENTE);
		funcionarioRepo.saveAll(Arrays.asList(funcionario1, funcionario2));

		PessoaEndereco pe1 = new PessoaEndereco(null, cliente1, endereco1);
		PessoaEndereco pe2 = new PessoaEndereco(null, cliente1, endereco2);
		PessoaEndereco pe3 = new PessoaEndereco(null, fornecedor1, endereco3);
		PessoaEndereco pe4 = new PessoaEndereco(null, funcionario1, endereco4);

		Telefone tel1 = new Telefone(null, "989311995");
		Telefone tel2 = new Telefone(null, "111111111");
		Telefone tel3 = new Telefone(null, "222222222");
		Telefone tel4 = new Telefone(null, "333333333");

		telefoneRepo.saveAll(Arrays.asList(tel1, tel2, tel3, tel4));

		PessoaTelefone pessoaTel1 = new PessoaTelefone(null, cliente1, tel1);
		PessoaTelefone pessoaTel2 = new PessoaTelefone(null, funcionario1, tel1);
		PessoaTelefone pessoaTel3 = new PessoaTelefone(null, fornecedor1, tel1);

		pessoaTelefoneRepo.saveAll(Arrays.asList(pessoaTel1, pessoaTel2, pessoaTel3));

		pessoaEnderecoRepo.saveAll(Arrays.asList(pe1, pe2, pe3, pe4));

		Venda venda = new Venda(null, Calendar.getInstance(), cliente1, funcionario1);

		Compra compra = new Compra(null, Calendar.getInstance(), fornecedor2, funcionario2);

		Orcamento orcamento = new Orcamento(null, Calendar.getInstance(), cliente2, funcionario1, false);

		VendaItem itemVenda = new VendaItem(null, null, produto1, new BigDecimal(10), new BigDecimal(2),
				new BigDecimal(0));
		venda.setItens(Arrays.asList(itemVenda));

		CompraItem itemCompra = new CompraItem(null, null, produto2, new BigDecimal(10), new BigDecimal(2),
				new BigDecimal(0));
		compra.setItens(Arrays.asList(itemCompra));

		OrcamentoItem itemOrcamento = new OrcamentoItem(null, orcamento, produto3, new BigDecimal(10),
				new BigDecimal(2), new BigDecimal(0));
		orcamento.setItens(Arrays.asList(itemOrcamento));

		FormaPagamento formaPagamento1 = new FormaPagamento(null, "dinheiro", TipoFormaPagamento.AVISTA);
		FormaPagamento formaPagamento2 = new FormaPagamento(null, "a prazo", TipoFormaPagamento.PRAZO);

		formaPagamentoRepo.saveAll(Arrays.asList(formaPagamento1, formaPagamento2));

		FormaPagamentoCompra formaPagamentoPedido1 = new FormaPagamentoCompra(null, compra, formaPagamento1,
				Calendar.getInstance(), new BigDecimal(200), EstadoPagamento.QUITADO);

		FormaPagamentoVenda formaPagamentoPedido2 = new FormaPagamentoVenda(null, venda, formaPagamento1,
				Calendar.getInstance(), new BigDecimal(10), EstadoPagamento.QUITADO);

		FormaPagamentoVenda formaPagamentoPedido3 = new FormaPagamentoVenda(null, venda, formaPagamento2,
				Calendar.getInstance(), new BigDecimal(90), EstadoPagamento.PENDENTE);

		ParcelaVenda parcela1 = new ParcelaVenda(null, formaPagamentoPedido3, new BigDecimal(40),
				EstadoPagamento.PENDENTE, Calendar.getInstance(), null);
		ParcelaVenda parcela2 = new ParcelaVenda(null, formaPagamentoPedido3, new BigDecimal(50),
				EstadoPagamento.PENDENTE, Calendar.getInstance(), null);

		ParcelaCompra parcela3 = new ParcelaCompra(null, formaPagamentoPedido1, new BigDecimal(70),
				EstadoPagamento.QUITADO, Calendar.getInstance(), Calendar.getInstance());

		formaPagamentoPedido3.setParcelas(Arrays.asList(parcela1, parcela2));
		formaPagamentoPedido1.setParcelas(Arrays.asList(parcela3));

		venda.setFormasPagamento(Arrays.asList(formaPagamentoPedido2, formaPagamentoPedido3));
		compra.setFormasPagamentos(Arrays.asList(formaPagamentoPedido1));

		ContaPagar conta1 = new ContaPagar(null, Calendar.getInstance(), new BigDecimal(200),
				EstadoPagamento.QUITADO, Calendar.getInstance(), Calendar.getInstance(), formaPagamentoPedido1, null);
		formaPagamentoPedido1.setContaPagar(conta1);
		
		ContaReceber conta2 = new ContaReceber(null, Calendar.getInstance(), new BigDecimal(10),
				EstadoPagamento.QUITADO, Calendar.getInstance(), Calendar.getInstance(), formaPagamentoPedido2, null);
		formaPagamentoPedido2.setContaReceber(conta2);
		
		ContaReceber conta3 = new ContaReceber(null, Calendar.getInstance(), new BigDecimal(45),
				EstadoPagamento.PENDENTE, null, Calendar.getInstance(), null, parcela1);
		parcela1.setContaReceber(conta3);
		
		ContaReceber conta4 = new ContaReceber(null, Calendar.getInstance(), new BigDecimal(45),
				EstadoPagamento.PENDENTE, null, Calendar.getInstance(), null, parcela2);
		parcela2.setContaReceber(conta4);
		
		pedidoVendaRepo.saveAll(Arrays.asList(venda));
		pedidoCompraRepo.saveAll(Arrays.asList(compra));
		orcamentoRepo.saveAll(Arrays.asList(orcamento));

		Caixa caixa1 = new Caixa(null, "caixa1");
		Caixa caixa2 = new Caixa(null, "caixa2");

		caixaRepo.saveAll(Arrays.asList(caixa1, caixa2));

		CaixaMovimentacao caixaMov1 = new CaixaMovimentacao(null, EstadoCaixa.ABERTO, Calendar.getInstance(), null,
				caixa1, funcionario1);
		CaixaMovimentacao caixaMov2 = new CaixaMovimentacao(null, EstadoCaixa.FECHADO, Calendar.getInstance(),
				Calendar.getInstance(), caixa2, funcionario2);

		caixaMovimentacaoRepo.saveAll(Arrays.asList(caixaMov1, caixaMov2));

		Movimentacao mov1 = new Movimentacao(null, caixaMov1, conta1.getId(), Calendar.getInstance(),
				new BigDecimal(200), TipoMovimentacao.SAIDA);
		Movimentacao mov2 = new Movimentacao(null, caixaMov1, conta2.getId(), Calendar.getInstance(),
				new BigDecimal(10), TipoMovimentacao.ENTRADA);
		Movimentacao mov3 = new Movimentacao(null, caixaMov1, conta3.getId(), Calendar.getInstance(),
				new BigDecimal(45), TipoMovimentacao.ENTRADA);
		Movimentacao mov4 = new Movimentacao(null, caixaMov1, conta4.getId(), Calendar.getInstance(),
				new BigDecimal(45), TipoMovimentacao.ENTRADA);
		Movimentacao mov5 = new Movimentacao(null, caixaMov2, null, Calendar.getInstance(), new BigDecimal(200),
				TipoMovimentacao.SANGRIA);

		movimentacaoRepo.saveAll(Arrays.asList(mov1, mov2, mov3, mov4, mov5));

		EntradaEstoque entrada1 = new EntradaEstoque(null, Calendar.getInstance(), Calendar.getInstance(), itemCompra,
				estoque1);

		//entradaEstoqueRepo.saveAll(Arrays.asList(entrada1));

	}
}
