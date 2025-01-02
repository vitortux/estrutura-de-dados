package my_arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Carro;
import vitor.dev.model.Model;
import vitor.dev.my_arrays.CarroArray;

class CarroArrayTest {
	private final CarroArray array = new CarroArray(10);
	private final Carro carro = new Carro(3, "foo");
	private final Model model = new Model(2);

	@Test
	void deveriaInserirCarro() {
		array.insert(carro);
		assertNotNull(array.getItems()[0]);
	}

	@Test
	void naoDeveriaInserirModeloIncorreto() {
		array.insert(model);
		assertNull(array.getItems()[0]);
	}

	@Test
	void deveriaRemoverCarro() {
		array.insert(carro);
		assertTrue(array.search(carro));

		array.remove(carro);
		assertNull(array.getItems()[0]);
		assertFalse(array.search(carro));
	}

	@Test
	void naoDeveriaRemoverObjetoNaoPresenteNoArray() {
		assertFalse(array.remove(carro));
	}

	@Test
	void naoDeveriaRemoverModeloIncorreto() {
		assertFalse(array.remove(model));
	}

	@Test
	void deveriaRetornarVerdadeiroParaModeloPresenteNoArray() {
		array.insert(carro);
		assertTrue(array.search(carro));
	}

	@Test
	void deveriaRetornarFalsoParaModeloNaoPresenteNoArray() {
		assertFalse(array.search(carro));
	}

	@Test
	void deveriaRetornarFalsoAoBuscarTipoDeModeloIncorreto() {
		assertFalse(array.search(model));
	}

	@Test
	void deveriaRetornarVerdadeiroParaCarroAtualizado() {
		array.insert(carro);
		assertTrue(array.update(carro, new Carro(22, "name")));
		assertNotEquals(carro, array.getItems()[0]);
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarModeloNaoPresenteNoArray() {
		assertFalse(array.update(carro, new Carro(2, "2")));
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarTipoDeModeloIncorreto() {
		assertFalse(array.update(model, new Model(2)));
	}
}
