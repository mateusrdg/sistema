package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Integer> {

}
