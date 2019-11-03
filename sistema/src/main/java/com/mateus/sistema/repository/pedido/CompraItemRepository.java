package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.CompraItem;

@Repository
public interface CompraItemRepository extends JpaRepository<CompraItem,Long> {

}
