package com.mateus.sistema.repository.pessoa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pessoa.Endereco;
import com.mateus.sistema.domain.pessoa.PessoaEndereco;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco, Long> {

	@Query("SELECT obj FROM PessoaEndereco obj WHERE obj.tipo = :tipo AND obj.pessoa = :pessoaId")
	List<PessoaEndereco> findByTipoAndPessoaId(@Param("tipo") Integer tipo, @Param("pessoaId") Long pessoaId);
	
	PessoaEndereco findByTipoAndPessoaAndEndereco(Integer tipo, Long pessoa, Endereco endereco);
}
