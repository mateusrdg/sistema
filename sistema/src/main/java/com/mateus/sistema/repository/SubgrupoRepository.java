package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Subgrupo;

@Repository
public interface SubgrupoRepository extends JpaRepository<Subgrupo,Integer> {

}
