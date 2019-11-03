package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra,Long> {

}
