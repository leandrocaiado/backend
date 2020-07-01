package br.com.prevent.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.prevent.service.imp.LogServiceImpl;

@SpringBootTest
class PreventApplicationTests {
	@Autowired
	private LogServiceImpl service;
	@Test
	void verificaNomeCavalo() {
		
		String nomeArquivo ="cavalo";
		
		boolean valorRetornado =false;
		
		valorRetornado = service.existsByNome(nomeArquivo);
		assertEquals(true, valorRetornado);
	}

}
