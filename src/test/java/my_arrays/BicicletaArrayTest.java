package my_arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.exception.DataStructureException;
import vitor.dev.model.Bicicleta;
import vitor.dev.model.Model;
import vitor.dev.my_arrays.BicicletaArray;

class BicicletaArrayTest {
	private final BicicletaArray array = new BicicletaArray(10);
	private final Bicicleta bicicleta = new Bicicleta(3, "foo");
	private final Model model = new Model(2);

	@Test
	void deveriaInserirBicicleta() {
		array.insert(bicicleta);
		assertNotNull(array.getItems()[0]);
	}

	@Test
	void naoDeveriaInserirModeloIncorreto() {
		array.insert(model);
		assertNull(array.getItems()[0]);
	}

	@Test
	void deveriaRemoverBicicleta() {
		array.insert(bicicleta);
		assertTrue(array.search(bicicleta));

		array.remove(bicicleta);
		assertNull(array.getItems()[0]);
		assertFalse(array.search(bicicleta));
	}

	@Test
	void deveriaRemoverItemNoMeio() {
		Bicicleta bicicleta1 = new Bicicleta(1, "bike1");
		Bicicleta bicicleta2 = new Bicicleta(2, "bike2");
		Bicicleta bicicleta3 = new Bicicleta(3, "bike3");

		array.insert(bicicleta1);
		array.insert(bicicleta2);
		array.insert(bicicleta3);

		assertTrue(array.remove(bicicleta2));
		assertNotNull(array.getItems()[1]);
		assertTrue(array.search(bicicleta1));
		assertTrue(array.search(bicicleta3));
		assertFalse(array.search(bicicleta2));
	}

	@Test
	void deveriaAtualizarBicicleta() {
		array.insert(bicicleta);

		Bicicleta novaBike = new Bicicleta(4, "");
		assertTrue(array.update(bicicleta, novaBike));

		assertNotEquals(bicicleta, array.getItems()[0]);
		assertEquals(novaBike, array.getItems()[0]);
	}

	@Test
	void naoDeveriaAtualizarBicicletaNaoEncontrada() {
		array.insert(bicicleta);

		Bicicleta bike = new Bicicleta(99, "inexistente");
		assertFalse(array.update(bike, new Bicicleta(10, "novo")));
	}

	@Test
	void naoDeveriaRemoverObjetoNaoPresenteNoArray() {
		assertFalse(array.remove(bicicleta));
	}

	@Test
	void naoDeveriaRemoverModeloIncorreto() {
		assertFalse(array.remove(model));
	}

	@Test
	void deveriaRetornarVerdadeiroParaModeloPresenteNoArray() {
		array.insert(bicicleta);
		assertTrue(array.search(bicicleta));
	}

	@Test
	void deveriaRetornarFalsoParaModeloNaoPresenteNoArray() {
		assertFalse(array.search(bicicleta));
	}

	@Test
	void deveriaRetornarFalsoAoBuscarTipoDeModeloIncorreto() {
		assertFalse(array.search(model));
	}

	@Test
	void deveriaRetornarVerdadeiroParaBicicletaAtualizada() {
		array.insert(bicicleta);
		assertTrue(array.update(bicicleta, new Bicicleta(22, "name")));
		assertNotEquals(bicicleta, array.getItems()[0]);
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarModeloNaoPresenteNoArray() {
		assertFalse(array.update(bicicleta, new Bicicleta(22, "name")));
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarTipoDeModeloIncorreto() {
		assertFalse(array.update(model, new Model(22)));
	}

	@Test
	void deveriaLancarDataStructureException() {
		assertThrowsExactly(DataStructureException.class, () -> {
			BicicletaArray newArray = new BicicletaArray(2);

			for (int index = 0; index < 10; index++) {
				newArray.insert(new Bicicleta(index, "null"));
			}
		});
	}
}
