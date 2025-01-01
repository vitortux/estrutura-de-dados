package my_arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import vitor.dev.my_arrays.CarroArray;
import vitor.dev.model.Carro;
import vitor.dev.model.Model;

class CarroArrayTest {
    private final CarroArray array = new CarroArray(10);
    private final Carro carro = new Carro(3, "foo");
    private final Model model = new Model(2);

    @Test
    void shouldInsertCarro() {
        array.insert(0, carro);
        assertNotNull(array.getItems()[0]);
    }

    @Test
    void shouldNotInsertIncorrectModel() {
        array.insert(0, model);
        assertNull(array.getItems()[0]);
    }

    @Test
    void shouldRemoveCar() {
        array.insert(0, carro);
        assertTrue(array.search(carro));

        array.remove(carro);
        assertNull(array.getItems()[0]);
        assertFalse(array.search(carro));
    }

    @Test
    void shouldNotRemoveObjectNotPresentInArray() {
        assertFalse(array.remove(carro));
    }

    @Test
    void shouldNotRemoveIncorrectModel() {
        assertFalse(array.remove(model));
    }

    @Test
    void shouldReturnTrueForModelPresentInArray() {
        array.insert(0, carro);
        assertTrue(array.search(carro));
    }

    @Test
    void shouldReturnFalseForModelNotPresentInArray() {
        assertFalse(array.search(carro));
    }

    @Test
    void shouldReturnFalseWhenSearchingForIncorrectModelType() {
        assertFalse(array.search(model));
    }

    @Test
    void shouldReturnTrueForUpdatedCarro() {
        array.insert(0, carro);
        assertTrue(array.update(0, new Carro(22, "name")));
        assertNotEquals(carro, array.getItems()[0]);
    }

    @Test
    void shouldReturnFalseWhenUpdatingModelNotPresentOnArray() {
        assertFalse(array.update(0, carro));
    }

    @Test
    void shouldReturnFalseWhenUpdatingIncorrectModelType() {
        assertFalse(array.update(0, model));
    }
}
