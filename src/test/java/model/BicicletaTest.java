package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Bicicleta;

class BicicletaTest {

	@Test
	void deveGerarAtributosNulosParaConstrutorDefault() {
		Bicicleta bicicleta = new Bicicleta();
		assertNull(bicicleta.getMarca());
		assertEquals(0, bicicleta.getNumeroMarchas());
		assertFalse(bicicleta.isTemRodinha());
		assertNull(bicicleta.getCor());
	}

	@Test
	void devePassaAtributosPeloConstrutor() {
		Bicicleta bicicleta = new Bicicleta(1, "Bike");

		assertEquals(1, bicicleta.getId());
		assertEquals("Bike", bicicleta.getMarca());
	}

	@Test
	void deveSetarAtributosDoObjeto() {
		Bicicleta bicicleta = new Bicicleta();
		bicicleta.setMarca("Bike");
		bicicleta.setNumeroMarchas(4);
		bicicleta.setTemRodinha(true);
		bicicleta.setCor("Azul");

		assertEquals("Bike", bicicleta.getMarca());
		assertEquals(4, bicicleta.getNumeroMarchas());
		assertTrue(bicicleta.isTemRodinha());
		assertEquals("Azul", bicicleta.getCor());
	}
}
