package com.mateus.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.PessoaEndereco;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Integer> {

	@Query("SELECT obj FROM PessoaEndereco obj WHERE obj.tipo = :tipo AND obj.pessoa = :pessoaId")
	List<PessoaEndereco> findByTipoAndPessoaId(@Param("tipo") Integer tipo, @Param("pessoaId") Integer pessoaId);
}
