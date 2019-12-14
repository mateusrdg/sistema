package com.mateus.sistema.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pessoa.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {

}
