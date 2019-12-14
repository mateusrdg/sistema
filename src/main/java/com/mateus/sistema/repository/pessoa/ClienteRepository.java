package com.mateus.sistema.repository.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mateus.sistema.domain.pessoa.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	Cliente findByEmail(String email);

}
