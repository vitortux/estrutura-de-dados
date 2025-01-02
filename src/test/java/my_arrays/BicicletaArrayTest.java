package my_arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Bicicleta;
import vitor.dev.model.Model;
import vitor.dev.my_arrays.BicicletaArray;

class BicicletaArrayTest {
	private final BicicletaArray array = new BicicletaArray(10);
	private final Bicicleta bicicleta = new Bicicleta(3, "foo");
	private final Model model = new Model(2);

	@Test
	void deveriaInserirBicicleta() {
		array.insert(0, bicicleta);
		assertNotNull(array.getItems()[0]);
	}

	@Test
	void naoDeveriaInserirModeloIncorreto() {
		array.insert(0, model);
		assertNull(array.getItems()[0]);
	}

	@Test
	void deveriaRemoverBicicleta() {
		array.insert(0, bicicleta);
		assertTrue(array.search(bicicleta));

		array.remove(bicicleta);
		assertNull(array.getItems()[0]);
		assertFalse(array.search(bicicleta));
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
		array.insert(0, bicicleta);
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
		array.insert(0, bicicleta);
		assertTrue(array.update(0, new Bicicleta(22, "name")));
		assertNotEquals(bicicleta, array.getItems()[0]);
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarModeloNaoPresenteNoArray() {
		assertFalse(array.update(0, bicicleta));
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarTipoDeModeloIncorreto() {
		assertFalse(array.update(0, model));
	}
}
