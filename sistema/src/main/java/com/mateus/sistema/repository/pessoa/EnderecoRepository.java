package com.mateus.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.Endereco;
import com.mateus.sistema.domain.PessoaEndereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
	
	@Query("SELECT DISTINCT obj FROM Endereco obj INNER JOIN obj.pessoaEnderecos pe WHERE pe IN :pessoaEnderecos")
	List<Endereco> findDistinctByPessoaEndereco( @Param("pessoaEnderecos") List<PessoaEndereco> enderecos);
	
}
