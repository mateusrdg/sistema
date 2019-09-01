package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Integer> {

}
