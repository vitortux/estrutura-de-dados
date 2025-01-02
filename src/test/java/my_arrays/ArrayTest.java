package my_arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vitor.dev.model.Model;
import vitor.dev.my_arrays.MyArray;

class ArrayTest {

	private final MyArray array = new MyArray(10);
	private final MyArray ascArray = new MyArray(10);
	private final MyArray descArray = new MyArray(10);

	@BeforeEach
	void setUp() {
		for (int i = 0; i < array.getItems().length; i++) {
			array.insert(i, new Model(i));
			ascArray.insert(i, new Model(i));
			descArray.insert(i, new Model(9 - i));
		}
	}

	@Test
	void deveriaOrdenarAscendente() {
		array.shuffle();
		array.orderByIdAsc();
		assertArrayEquals(ascArray.getItems(), array.getItems());
	}

	@Test
	void deveriaOrdenarDescendente() {
		array.shuffle();
		array.orderByIdDesc();
		assertArrayEquals(descArray.getItems(), array.getItems());
	}

	@Test
	void deveriaEmbaralharArray() {
		Model[] originalArray = array.getItems().clone();

		assertArrayEquals(originalArray, array.getItems());

		array.shuffle();

		assertFalse(Arrays.equals(originalArray, array.getItems()));
	}
}
