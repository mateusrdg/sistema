package com.mateus.sistema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {

}
