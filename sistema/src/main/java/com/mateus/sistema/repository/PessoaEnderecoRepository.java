package com.mateus.sistema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.PessoaEndereco;
import com.mateus.sistema.domain.enums.TipoPessoa;

@Repository
public interface PessoaEnderecoRepository extends JpaRepository<PessoaEndereco,Integer> {
	 List<PessoaEndereco> findByTipoAndPessoaid(TipoPessoa tipo, Integer id);
}
 