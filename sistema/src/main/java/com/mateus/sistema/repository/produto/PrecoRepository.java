package com.mateus.sistema.repository.produto;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.produto.Preco;
import com.mateus.sistema.domain.produto.Produto;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {
	@Query("SELECT obj.valor FROM Preco obj where obj.tipo = :tipo AND obj.produto = :produto ")
	public Optional<BigDecimal> findValorByTipoAndProduto(Integer tipo, Produto produto);
}
