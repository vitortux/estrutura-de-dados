package data_structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import vitor.dev.data_structures.MyList;
import vitor.dev.data_structures.MySet;
import vitor.dev.model.Model;

class IteratorsTest {

    private MyList<Model> myList;
    private MySet<Integer> mySet;

    private Iterator<Model> myListIterator;
    private Iterator<Integer> mySetIterator;

    @BeforeEach
    void setUp() {
        myList = new MyList<>();
        mySet = new MySet<>();

        myListIterator = myList.iterator();
        mySetIterator = mySet.iterator();

        for (int i = 0; i < 10; i++) {
            myList.add(new Model(i));
            mySet.add(i);
        }
    }

    @Test
    void shouldHaveNext() {
        assertTrue(myListIterator.hasNext());
        assertTrue(mySetIterator.hasNext());
    }

    @Test
    void shouldReturnNextElement() {
        Model model = myListIterator.next();
        Integer integer = mySetIterator.next();

        assertNotNull(model);
        assertEquals(myList.get(0), model);

        assertNotNull(integer);
    }

    @Test
    void shouldNotHaveNext() {
        myList.clear();
        mySet.clear();

        assertFalse(myListIterator.hasNext());
        assertFalse(mySetIterator.hasNext());
    }

    @Test
    void shouldNotReturnNext() {
        myList.clear();
        mySet.clear();

        assertThrows(NoSuchElementException.class, myListIterator::next);
        assertThrows(NoSuchElementException.class, mySetIterator::next);
    }
}
