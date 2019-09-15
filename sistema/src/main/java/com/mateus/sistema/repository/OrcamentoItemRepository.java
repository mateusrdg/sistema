package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.OrcamentoItem;

@Repository
public interface OrcamentoItemRepository extends JpaRepository<OrcamentoItem,Integer> {

}
