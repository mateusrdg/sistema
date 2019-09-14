package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.PessoaTelefone;

@Repository
public interface PessoaTelefoneRepository extends JpaRepository<PessoaTelefone,Integer> {

}
