package com.mateus.sistema.repository.pessoa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pessoa.PessoaTelefone;

@Repository
public interface PessoaTelefoneRepository extends JpaRepository<PessoaTelefone,Long> {
	
	@Query("SELECT obj FROM PessoaTelefone obj WHERE obj.tipo = :tipo AND obj.pessoa = :pessoaId")
	List<PessoaTelefone> findByTipoAndPessoaId(@Param("tipo") Integer tipo, @Param("pessoaId") Long pessoaId);
}
