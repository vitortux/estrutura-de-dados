package my_arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.model.Model;
import vitor.dev.model.Pessoa;
import vitor.dev.my_arrays.PessoaArray;

class PessoaArrayTest {
	private final PessoaArray array = new PessoaArray(10);
	private final Pessoa pessoa = new Pessoa(3, "foo");
	private final Model model = new Model(2);

	@Test
	void deveriaInserirPessoa() {
		array.insert(pessoa);
		assertNotNull(array.getItems()[0]);
	}

	@Test
	void naoDeveriaInserirModeloIncorreto() {
		array.insert(model);
		assertNull(array.getItems()[0]);
	}

	@Test
	void deveriaRemoverPessoa() {
		array.insert(pessoa);
		assertTrue(array.search(pessoa));

		array.remove(pessoa);
		assertNull(array.getItems()[0]);
		assertFalse(array.search(pessoa));
	}

	@Test
	void naoDeveriaRemoverObjetoNaoPresenteNoArray() {
		assertFalse(array.remove(pessoa));
	}

	@Test
	void naoDeveriaRemoverModeloIncorreto() {
		assertFalse(array.remove(model));
	}

	@Test
	void deveriaRetornarVerdadeiroParaModeloPresenteNoArray() {
		array.insert(pessoa);
		assertTrue(array.search(pessoa));
	}

	@Test
	void deveriaRetornarFalsoParaModeloNaoPresenteNoArray() {
		assertFalse(array.search(pessoa));
	}

	@Test
	void deveriaRetornarFalsoAoBuscarTipoDeModeloIncorreto() {
		assertFalse(array.search(model));
	}

	@Test
	void deveriaRetornarVerdadeiroParaPessoaAtualizada() {
		array.insert(pessoa);
		assertTrue(array.update(pessoa, new Pessoa(22, "name")));
		assertNotEquals(pessoa, array.getItems()[0]);
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarModeloNaoPresenteNoArray() {
		assertFalse(array.update(pessoa, new Pessoa(22, "douglas")));
	}

	@Test
	void deveriaRetornarFalsoAoAtualizarTipoDeModeloIncorreto() {
		assertFalse(array.update(model, new Model(22)));
	}
}
