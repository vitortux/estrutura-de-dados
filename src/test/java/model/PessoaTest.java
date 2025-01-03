package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Pessoa;

class PessoaTest {

	@Test
	void deveGerarAtributosNulosParaConstrutorDefault() {
		Pessoa pessoa = new Pessoa();
		assertNull(pessoa.getName());
		assertNull(pessoa.getRg());
		assertNull(pessoa.getCpf());
		assertEquals(0, pessoa.getTelefone());
		assertNull(pessoa.getNacionalidade());
	}

	@Test
	void devePassarAtributosPeloConstrutor() {
		Pessoa pessoa = new Pessoa(1, "João");

		assertEquals(1, pessoa.getId());
		assertEquals("João", pessoa.getName());
	}

	@Test
	void deveSetarAtributosDoObjeto() {
		Pessoa pessoa = new Pessoa();
		pessoa.setName("João");
		pessoa.setRg("123456789");
		pessoa.setCpf("98765432100");
		pessoa.setTelefone(123456789);
		pessoa.setNacionalidade("Brasileira");

		assertEquals("João", pessoa.getName());
		assertEquals("123456789", pessoa.getRg());
		assertEquals("98765432100", pessoa.getCpf());
		assertEquals(123456789, pessoa.getTelefone());
		assertEquals("Brasileira", pessoa.getNacionalidade());
	}
}
