package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Carro;

class CarroTest {

	@Test
	void deveGerarAtributosNulosParaConstrutorDefault() {
		Carro carro = new Carro();
		assertNull(carro.getMarca());
		assertNull(carro.getModelo());
		assertEquals(0, carro.getAno());
		assertNull(carro.getTipoCombustivel());
	}

	@Test
	void devePassaAtributosPeloConstrutor() {
		Carro carro = new Carro(1, "Toyota");

		assertEquals(1, carro.getId());
		assertEquals("Toyota", carro.getMarca());
	}

	@Test
	void deveSetarAtributosDoObjeto() {
		Carro carro = new Carro();
		carro.setMarca("Toyota");
		carro.setModelo("Corolla");
		carro.setAno(2020);
		carro.setTipoCombustivel("Gasolina");

		assertEquals("Toyota", carro.getMarca());
		assertEquals("Corolla", carro.getModelo());
		assertEquals(2020, carro.getAno());
		assertEquals("Gasolina", carro.getTipoCombustivel());
	}
}
