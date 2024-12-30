package array;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.array.PersonArray;
import vitor.dev.model.Model;
import vitor.dev.model.Person;

class PersonArrayTest {
	private final PersonArray array = new PersonArray(10);
	private final Person person = new Person(3, "foo");
	private final Model model = new Model(2);

	@Test
	void shouldInsertPerson() {
		array.insert(0, person);
		assertNotNull(array.getItems()[0]);
	}

	@Test
	void shouldNotInsertIncorrectModel() {
		array.insert(0, model);
		assertNull(array.getItems()[0]);
	}

	@Test
	void shouldRemovePerson() {
		array.insert(0, person);
		assertTrue(array.search(person));

		array.remove(person);
		assertNull(array.getItems()[0]);
		assertFalse(array.search(person));
	}

	@Test
	void shouldNotRemoveObjectNotPresentInArray() {
		assertFalse(array.remove(person));
	}

	@Test
	void shouldNotRemoveIncorrectModel() {
		assertFalse(array.remove(model));
	}

	@Test
	void shouldReturnTrueForModelPresentInArray() {
		array.insert(0, person);
		assertTrue(array.search(person));
	}

	@Test
	void shouldReturnFalseForModelNotPresentInArray() {
		assertFalse(array.search(person));
	}

	@Test
	void shouldReturnFalseWhenSearchingForIncorrectModelType() {
		assertFalse(array.search(model));
	}

	@Test
	void shouldReturnTrueForUpdatedPerson() {
		array.insert(0, person);
		assertTrue(array.update(0, new Person(22, "name")));
		assertNotEquals(person, array.getItems()[0]);
	}

	@Test
	void shouldReturnFalseWhenUpdatingModelNotPresentOnArray() {
		assertFalse(array.update(0, person));
	}

	@Test
	void shouldReturnFalseWhenUpdatingIncorrectModelType() {
		assertFalse(array.update(0, model));
	}
}
