package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vitor.dev.data_structures.MyMap;

class MyMapTest {

    private MyMap<Integer, Character> myMap;

    @BeforeEach
    void setUp() {
        myMap = new MyMap<>();

        for (int i = 0; i < 10; i++) {
            myMap.put(i, (char) (97 + i));
        }
    }

    @Test
    void shouldReturnFalseForEmptyList() {
        assertFalse(myMap.isEmpty());
    }

    @Test
    void shouldClearMap() {
        myMap.clear();
        assertTrue(myMap.isEmpty());
        assertEquals(0, myMap.size());
    }

    @Test
    void shouldReplaceValueForExistingKey() {
        Object c = myMap.put(1, 'c');
        assertNotNull(c);
        assertTrue(myMap.containsValue('c'));
    }

    @Test
    void shouldReturnNullValueForNonExistingKey() {
        assertFalse(myMap.containsValue('l'));
    }

    @Test
    void shouldReturnNullWhenPuttingNullKey() {
        assertNull(myMap.put(null, 'l'));
        assertFalse(myMap.containsValue('l'));
    }

    @Test
    void shouldIncreaseListSizeOnLimit() {
        assertEquals(10, myMap.size());
        assertNull(myMap.put(11, 'c'));
        assertEquals(11, myMap.size());
        assertTrue(myMap.containsKey(11));
    }

    @Test
    void shouldReturnElementPresentOnMap() {
        Object c = myMap.get(1);
        assertNotNull(c);
        assertEquals('b', c);
    }

    @Test
    void shouldReturnNullForElementNotOnMap() {
        assertNull(myMap.get(11));
    }

    @Test
    void shouldNotContainKey() {
        assertFalse(myMap.containsKey(11));
    }

    @Test
    void shouldPutElementsFromAnotherMap() {
        assertEquals(10, myMap.size());

        MyMap<Integer, Character> mapToPut = new MyMap<>();
        mapToPut.put(11, 'l');
        mapToPut.put(12, 'm');

        myMap.putAll(mapToPut);

        assertEquals(12, myMap.size());
        assertTrue(myMap.containsValue('l'));
    }

    @Test
    void shouldRemoveExistingKey() {
        Object removedValue = myMap.remove(2);

        assertEquals('c', removedValue);
        assertNull(myMap.get(2));
        assertEquals(9, myMap.size());
    }

    @Test
    void shouldNotRemoveNonExistingKey() {
        Object removedValue = myMap.remove(11);

        assertNull(removedValue);
        assertEquals(10, myMap.size());
    }

    @Test
    void shouldGenerateSetKey() {
        Set<Integer> keySet = myMap.keySet();

        assertTrue(keySet.contains(1));
        assertTrue(keySet.contains(2));
        assertTrue(keySet.contains(3));

        assertFalse(keySet.contains(11));
    }

    @Test
    void shouldGenerateEntryMap() {
        Set<MyMap.Entry<Integer, String>> entrySet = myMap.entrySet();
        assertNotNull(entrySet);
        assertEquals(entrySet.size(), myMap.size());
    }

    @Test
    void generatedSetShouldBeEmpty() {
        myMap.clear();

        Set<MyMap.Entry<Integer, String>> entrySet = myMap.entrySet();

        assertNotNull(entrySet);
        assertTrue(entrySet.isEmpty());
    }

    @Test
    void shouldReturnEmptyValuesArray() {
        myMap.clear();

        Object[] values = myMap.values();

        assertNotNull(values);
        assertEquals(0, values.length);
    }

    @Test
    void shouldReturnValuesArray() {
        Object[] values = myMap.values();

        assertNotNull(values);
        assertEquals(10, values.length);
    }
}
