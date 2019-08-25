package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ProdutoEstoque;

@Repository
public interface EstoqueProdutoRepository extends JpaRepository<ProdutoEstoque,Integer> {

}
