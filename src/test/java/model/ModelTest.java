package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Model;

class ModelTest {

	@Test
	void testEqualsComMesmoId() {
		Model model1 = new Model();
		model1.setId(1);
		Model model2 = new Model();
		model2.setId(1);

		assertEquals(model1, model2);
	}

	@Test
	void testEqualsComIdsDiferentes() {
		Model model1 = new Model();
		model1.setId(1);
		Model model2 = new Model();
		model2.setId(2);

		assertNotEquals(model1, model2);
	}

	@Test
	void testEqualsComObjetoNull() {
		Model model = new Model();
		Model modelNull = null;
		assertNotEquals(null, model);
		assertNotEquals(model, modelNull);
	}

	@Test
	void testHashCodeComMesmoId() {
		Model model1 = new Model();
		model1.setId(1);
		Model model2 = new Model();
		model2.setId(1);

		assertEquals(model1.hashCode(), model2.hashCode());
	}

	@Test
	void testHashCodeComIdsDiferentes() {
		Model model1 = new Model();
		model1.setId(1);
		Model model2 = new Model();
		model2.setId(2);

		assertNotEquals(model1.hashCode(), model2.hashCode());
	}

	@Test
	void testEqualsComMesmoObjeto() {
		Model model = new Model();
		model.setId(1);
		assertEquals(model, model);
	}

	@Test
	void testEqualsComClasseDiferente() {
		Model model = new Model();
		model.setId(1);

		String str = "Test String";

		assertNotEquals(model, str);
	}
}
