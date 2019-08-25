package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque,Integer> {

}
