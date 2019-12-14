package com.mateus.sistema.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.produto.ProdutoSubgrupo;

@Repository
public interface ProdutoSubgrupoRepository extends JpaRepository<ProdutoSubgrupo,Long> {

}
