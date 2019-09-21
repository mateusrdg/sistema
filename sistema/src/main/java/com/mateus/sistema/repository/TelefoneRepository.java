package com.mateus.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.PessoaTelefone;
import com.mateus.sistema.domain.Telefone;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone,Integer> {
	
	@Query("SELECT DISTINCT obj FROM Telefone obj INNER JOIN obj.pessoaTelefones pt WHERE pt IN :pessoaTelefones")
	List<Telefone> findDistinctByPessoaTelefone( @Param("pessoaTelefones") List<PessoaTelefone> telefones);

}
