package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vitor.dev.data_structures.MySet;

class MySetTest {

    private MySet<Integer> mySet;

    @BeforeEach
    void setUp() {
        mySet = new MySet<>();

        for (int i = 0; i < 10; i++) {
            mySet.add(i);
        }
    }

    @Test
    void shouldGrowWhenReachingDefaultCapacity() {
        mySet.add(11);
        assertEquals(11, mySet.size());
    }

    @Test
    void shouldNotGrowWhenReachingDefaultCapacity() {
        mySet.add(1);
        assertEquals(10, mySet.size());
    }

    @Test
    void currentListShouldNotBeEmpty() {
        assertFalse(mySet.isEmpty());
    }

    @Test
    void shouldClearList() {
        mySet.clear();
        assertEquals(0, mySet.size());
        assertTrue(mySet.isEmpty());
    }

    @Test
    void shouldRemoveObject() {
        assertTrue(mySet.remove(6));

        mySet.add(11);
        assertTrue(mySet.remove(11));
    }

    @Test
    void shouldNotRemoveOnEmptySet() {
        mySet.clear();
        assertFalse(mySet.remove(1));
    }

    @Test
    void shouldReturnTrueWhenAllElementsArePresent() {
        MySet<Integer> collection = new MySet<>();
        collection.add(1);
        collection.add(2);

        assertTrue(mySet.containsAll(collection));
    }

    @Test
    void shouldReturnFalseWhenNotAllElementsArePresent() {
        MySet<Integer> collection = new MySet<>();
        collection.add(11);
        collection.add(22);

        assertFalse(mySet.containsAll(collection));
    }

    @Test
    void shouldAddAllElementsToMyList() {
        MySet<Integer> collection = new MySet<>();
        collection.add(12);
        collection.add(22);
        collection.add(23);

        assertTrue(mySet.addAll(collection));
        assertTrue(mySet.containsAll(collection));
        assertEquals(13, mySet.size());
    }

    @Test
    void shouldNotAddDuplicateElementsToMyList() {
        MySet<Integer> collection = new MySet<>();
        collection.add(1);
        collection.add(22);
        collection.add(23);

        assertTrue(mySet.addAll(collection));
        assertTrue(mySet.containsAll(collection));
        assertEquals(12, mySet.size());
    }

    @Test
    void shouldRemoveAllItemsPresentOnList() {
        MySet<Integer> collection = new MySet<>();
        collection.add(1);
        collection.add(3);

        assertTrue(mySet.removeAll(collection));
        assertEquals(8, mySet.size());
    }

    @Test
    void shouldNotRemoveItemsNotPresentOnList() {
        MySet<Integer> collection = new MySet<>();
        collection.add(100);

        assertFalse(mySet.removeAll(collection));
        assertEquals(10, mySet.size());
    }

    @Test
    void shouldRetainAllIntersectionNonEmpty() {
        MySet<Integer> toRetain = new MySet<>();
        toRetain.add(1);
        toRetain.add(3);
        toRetain.add(5);

        assertTrue(mySet.retainAll(toRetain));
        assertEquals(3, mySet.size());
    }

    @Test
    void shouldRetainAllEmptySet() {
        MySet<Integer> emptySet = new MySet<>();

        assertTrue(mySet.retainAll(emptySet));
        assertEquals(0, mySet.size());
    }

    @Test
    void shouldConvertToArrayCorrectly() {
        Object[] array = mySet.toArray();

        assertEquals(mySet.size(), array.length);

        for (int i = 0; i < mySet.size(); i++) {
            assertEquals(i, array[i]);
        }
    }

    @Test
    void shouldConvertToArrayCorrectlyWithInsuficientSize() {
        Object[] array = new Object[2];
        array = mySet.toArray(array);

        assertEquals(mySet.size(), array.length);

        for (int i = 0; i < mySet.size(); i++) {
            assertEquals(i, array[i]);
        }
    }

    @Test
    void shouldConvertToArrayCorrectlyWithMoreThanSuficientSize() {
        Object[] array = new Object[20];
        array = mySet.toArray(array);

        assertEquals(20, array.length);

        for (int i = 0; i < mySet.size(); i++) {
            assertEquals(i, array[i]);
        }
    }

    @Test
    void shouldReturnEmptyArrayForEmptySet() {
        mySet.clear();
        Object[] array = mySet.toArray();

        assertEquals(0, array.length);
    }
}
