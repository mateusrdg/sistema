package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long> {

}
