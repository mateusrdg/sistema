package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ContaPagar;

@Repository
public interface ContaPagarRepository extends JpaRepository<ContaPagar,Long> {

}
