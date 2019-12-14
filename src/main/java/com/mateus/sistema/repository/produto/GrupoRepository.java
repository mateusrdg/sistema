package com.mateus.sistema.repository.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.produto.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo,Long> {

}
