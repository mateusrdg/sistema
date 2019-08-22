package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Integer> {

}
