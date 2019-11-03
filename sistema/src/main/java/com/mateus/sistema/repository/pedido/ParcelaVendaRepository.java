package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ParcelaVenda;

@Repository
public interface ParcelaVendaRepository extends JpaRepository<ParcelaVenda,Long> {

}
