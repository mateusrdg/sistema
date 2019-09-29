package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.EntradaEstoque;

@Repository
public interface EntradaEstoqueRepository extends JpaRepository<EntradaEstoque,Long> {

}
