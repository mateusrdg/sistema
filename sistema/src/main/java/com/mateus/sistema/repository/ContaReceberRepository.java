package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.ContaReceber;

@Repository
public interface ContaReceberRepository extends JpaRepository<ContaReceber,Integer> {

}
