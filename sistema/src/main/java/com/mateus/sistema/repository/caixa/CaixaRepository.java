package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa,Long> {

}
