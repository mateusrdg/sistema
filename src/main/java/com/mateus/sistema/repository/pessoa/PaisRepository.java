package com.mateus.sistema.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pessoa.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais,Long> {

}
