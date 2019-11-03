package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Preco;

@Repository
public interface PrecoRepository extends JpaRepository<Preco,Long> {

}
