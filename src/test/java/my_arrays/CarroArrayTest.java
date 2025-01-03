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

		assertTrue(array.remove(carro));
		assertNull(array.getItems()[0]);
		assertFalse(array.search(carro));
	}

	@Test
	void deveriaRemoverCarroNoMeio() {
		Carro carro1 = new Carro(1, "Fusca");
		Carro carro2 = new Carro(2, "Civic");
		Carro carro3 = new Carro(3, "Uno");

		array.insert(carro1);
		array.insert(carro2);
		array.insert(carro3);

		assertTrue(array.remove(carro2));
		assertNotNull(array.getItems()[1]);
		assertTrue(array.search(carro1));
		assertTrue(array.search(carro3));
		assertFalse(array.search(carro2));
	}

	@Test
	void naoDeveriaRemoverModeloInexistente() {
		assertFalse(array.remove(carro));
	}

	@Test
	void deveriaAtualizarCarro() {
		array.insert(carro);

		Carro novoCarro = new Carro(4, "");
		assertTrue(array.update(carro, novoCarro));

		assertNotEquals(carro, array.getItems()[0]);
		assertEquals(novoCarro, array.getItems()[0]);
	}

	@Test
	void naoDeveriaAtualizarCarroNaoEncontrado() {
		array.insert(carro);

		Carro carroNaoExistente = new Carro(99, "inexistente");
		assertFalse(array.update(carroNaoExistente, new Carro(10, "novo")));
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

	@Test
	void deveriaLancarDataStructureException() {
		assertThrowsExactly(DataStructureException.class, () -> {
			CarroArray newArray = new CarroArray(2);

			for (int index = 0; index < 10; index++) {
				newArray.insert(new Carro(index, "null"));
			}
		});
	}
}
