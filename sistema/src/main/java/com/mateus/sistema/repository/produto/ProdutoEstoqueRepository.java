package com.mateus.sistema.repository.produto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.produto.Estoque;
import com.mateus.sistema.domain.produto.Produto;
import com.mateus.sistema.domain.produto.ProdutoEstoque;

@Repository
public interface ProdutoEstoqueRepository extends JpaRepository<ProdutoEstoque,Long> {
	
	@Query("SELECT obj FROM ProdutoEstoque obj where obj.produto = :produto AND obj.estoque = :estoque")
    public Optional<ProdutoEstoque> findByProdutoAndEstoque(Produto produto, Estoque estoque);
}
