package com.mateus.sistema.services.caixa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mateus.sistema.domain.caixa.CaixaMovimentacao;
import com.mateus.sistema.domain.caixa.Movimentacao;
import com.mateus.sistema.domain.enums.TipoMovimentacao;
import com.mateus.sistema.domain.pedido.Compra;
import com.mateus.sistema.domain.pedido.FormaPagamentoCompra;
import com.mateus.sistema.domain.pedido.FormaPagamentoVenda;
import com.mateus.sistema.domain.pedido.ParcelaCompra;
import com.mateus.sistema.domain.pedido.ParcelaVenda;
import com.mateus.sistema.domain.pedido.Pedido;
import com.mateus.sistema.domain.pedido.Venda;
import com.mateus.sistema.repository.caixa.CaixaMovimentacaoRepository;
import com.mateus.sistema.repository.caixa.MovimentacaoRepository;
import com.mateus.sistema.services.exceptions.ObjectNotFoundException;

@Service
public class CaixaMovimentacaoService {
	@Autowired
	private CaixaMovimentacaoRepository repo;
	@Autowired
	private MovimentacaoRepository movRepo;

	public CaixaMovimentacao find(Long id) {
		Optional<CaixaMovimentacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + CaixaMovimentacao.class.getName()));
	}

	public List<CaixaMovimentacao> findAll() {
		return repo.findAll();
	}

	public void geraCaixa(Pedido pedido) {
		movRepo.saveAll(getMovimentacoes(pedido));
	}

	// TODO
	// Planejar uma forma de passar o "caixa ativo".
	public List<Movimentacao> getMovimentacoes(Pedido pedido) {
		List<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();
		if (pedido instanceof Venda) {
			for (FormaPagamentoVenda fp : ((Venda) pedido).getFormasPagamento()) {
				if (fp.getContaReceber() != null) {
					movimentacoes.add(new Movimentacao(null, find(new Long(3)), fp.getContaReceber().getId(),
							fp.getContaReceber().getValor(), TipoMovimentacao.ENTRADA));
				}
				for (ParcelaVenda parcela : fp.getParcelas()) {
					movimentacoes.add(new Movimentacao(null, find(new Long(3)), parcela.getContaReceber().getId(),
							parcela.getContaReceber().getValor(), TipoMovimentacao.ENTRADA));
				}
			}
		} else if (pedido instanceof Compra) {
			for (FormaPagamentoCompra fp : ((Compra) pedido).getFormasPagamento()) {
				if (fp.getContaPagar() != null) {
					movimentacoes.add(new Movimentacao(null, find(new Long(3)), fp.getContaPagar().getId(),
							fp.getContaPagar().getValor(), TipoMovimentacao.SAIDA));
				}
				for (ParcelaCompra parcela : fp.getParcelas()) {
					movimentacoes.add(new Movimentacao(null, find(new Long(3)), parcela.getContaPagar().getId(),
							parcela.getContaPagar().getValor(), TipoMovimentacao.SAIDA));
				}
			}
		}
		return movimentacoes;
	}
}
