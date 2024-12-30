package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vitor.dev.array.MyArray;
import vitor.dev.model.Model;

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

		Collections.shuffle(Arrays.asList(array.getItems()));
	}

	@Test
	void shouldOrderAsc() {
		array.orderByIdAsc();
		assertArrayEquals(ascArray.getItems(), array.getItems());
	}

	@Test
	void shouldOrderDesc() {
		array.orderByIdDesc();
		assertArrayEquals(descArray.getItems(), array.getItems());
	}
}
