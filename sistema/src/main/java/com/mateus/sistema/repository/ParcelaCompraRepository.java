package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ParcelaCompra;

@Repository
public interface ParcelaCompraRepository extends JpaRepository<ParcelaCompra,Long> {

}
