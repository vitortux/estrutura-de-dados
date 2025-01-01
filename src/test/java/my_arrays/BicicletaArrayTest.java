package my_arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Bicicleta;
import vitor.dev.model.Model;
import vitor.dev.model.Pessoa;
import vitor.dev.my_arrays.BicicletaArray;

class BicicletaArrayTest {
	private final BicicletaArray array = new BicicletaArray(10);
	private final Bicicleta bicicleta = new Bicicleta(3, "foo");
	private final Model model = new Model(2);

	@Test
	void shouldInsertPerson() {
		array.insert(0, bicicleta);
		assertNotNull(array.getItems()[0]);
	}

	@Test
	void shouldNotInsertIncorrectModel() {
		array.insert(0, model);
		assertNull(array.getItems()[0]);
	}

	@Test
	void shouldRemovePerson() {
		array.insert(0, bicicleta);
		assertTrue(array.search(bicicleta));

		array.remove(bicicleta);
		assertNull(array.getItems()[0]);
		assertFalse(array.search(bicicleta));
	}

	@Test
	void shouldNotRemoveObjectNotPresentInArray() {
		assertFalse(array.remove(bicicleta));
	}

	@Test
	void shouldNotRemoveIncorrectModel() {
		assertFalse(array.remove(model));
	}

	@Test
	void shouldReturnTrueForModelPresentInArray() {
		array.insert(0, bicicleta);
		assertTrue(array.search(bicicleta));
	}

	@Test
	void shouldReturnFalseForModelNotPresentInArray() {
		assertFalse(array.search(bicicleta));
	}

	@Test
	void shouldReturnFalseWhenSearchingForIncorrectModelType() {
		assertFalse(array.search(model));
	}

	@Test
	void shouldReturnTrueForUpdatedPerson() {
		array.insert(0, bicicleta);
		assertTrue(array.update(0, new Bicicleta(22, "name")));
		assertNotEquals(bicicleta, array.getItems()[0]);
	}

	@Test
	void shouldReturnFalseWhenUpdatingModelNotPresentOnArray() {
		assertFalse(array.update(0, bicicleta));
	}

	@Test
	void shouldReturnFalseWhenUpdatingIncorrectModelType() {
		assertFalse(array.update(0, model));
	}
}
