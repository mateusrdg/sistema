package com.mateus.sistema;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mateus.sistema.domain.produto.Produto;

public class TesteTeste {
	
	@Test 
	public void testeProduto () {
		Produto p = new Produto(null, "a", "ref");
		p.getPrecos();
	}
	
	@Test
	public void testandoTeste() {
		assertTrue( ClasseParaTestar.retornaDois() == 2 );
	}
	
	@Before
	public void before () {
		System.out.println("Iniciando teste");
	}
	
	@After
	public void after () {
		System.out.println("Finalizando teste");
	}
}
