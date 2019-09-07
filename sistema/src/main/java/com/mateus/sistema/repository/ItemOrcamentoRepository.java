package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ItemOrcamento;

@Repository
public interface ItemOrcamentoRepository extends JpaRepository<ItemOrcamento,Integer> {

}
