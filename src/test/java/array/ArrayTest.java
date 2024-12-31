package array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
	}

	@Test
	void shouldOrderAsc() {
		array.shuffle();
		array.orderByIdAsc();
		assertArrayEquals(ascArray.getItems(), array.getItems());
	}

	@Test
	void shouldOrderDesc() {
		array.shuffle();
		array.orderByIdDesc();
		assertArrayEquals(descArray.getItems(), array.getItems());
	}

	@Test
	void shouldShuffleArray() {
		Model[] originalArray = array.getItems().clone();
		array.shuffle();

		int shuffledPositions = 0;

		for (int i = 0; i < originalArray.length; i++) {
			if (originalArray[i] != array.getItems()[i]) {
				shuffledPositions++;
			}
		}

		assertTrue(shuffledPositions > 0);
	}
}
