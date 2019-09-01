package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.PessoaEndereco;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco,Integer> {

}
