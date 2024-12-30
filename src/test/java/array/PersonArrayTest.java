package array;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void shouldThrowIllegalArgumentExceptionWhenInsertingInvalidModel() {
        assertThrows(IllegalArgumentException.class, () -> array.insert(0, model));
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
    void shouldNotRemovePerson() {
        assertFalse(array.remove(person));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenRemovingInvalidModel() {
        assertThrows(IllegalArgumentException.class, () -> array.remove(model));
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
    void shouldThrowIllegalArgumentExceptionWhenSearchingInvalidModel() {
        assertThrows(IllegalArgumentException.class, () -> array.search(model));
    }

    @Test
    void shouldReturnTrueForUpdatedPerson() {
        array.insert(0, person);
        assertTrue(array.update(0, new Person(22, "name")));
        assertNotEquals(person, array.getItems()[0]);
    }

    @Test
    void shouldReturnFalseWehnUPdatingModelNotPresentOnArray() {
        assertFalse(array.update(0, person));
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenUpdatingInvalidModel() {
        assertThrows(IllegalArgumentException.class, () -> array.update(0, model));
    }
}
