package com.mateus.sistema.repository.caixa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.caixa.CaixaMovimentacao;

@Repository
public interface CaixaMovimentacaoRepository extends JpaRepository<CaixaMovimentacao,Long> {

}
