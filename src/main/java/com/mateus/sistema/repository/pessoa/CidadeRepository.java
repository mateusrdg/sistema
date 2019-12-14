package com.mateus.sistema.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pessoa.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Long> {

}
