package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.VendaItem;

@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem,Long> {

}
