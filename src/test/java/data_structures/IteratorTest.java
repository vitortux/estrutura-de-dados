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
import vitor.dev.model.Model;

class IteratorTest {

    private MyList<Model> myList;

    @BeforeEach
    void setUp() {
        myList = new MyList<>();

        for (int i = 0; i < 10; i++) {
            myList.add(new Model(i));
        }
    }

    @Test
    void shouldHaveNext() {
        Iterator<Model> iterator = myList.iterator();
        assertTrue(iterator.hasNext());
    }

    @Test
    void shouldReturnNextElement() {
        Iterator<Model> iterator = myList.iterator();
        Model model = iterator.next();
        assertNotNull(model);
        assertEquals(myList.get(0), model);
    }

    @Test
    void shouldNotHaveNext() {
        Iterator<Model> iterator = myList.iterator();
        myList.clear();
        assertFalse(iterator.hasNext());
    }

    @Test
    void shouldNotReturnNext() {
        Iterator<Model> iterator = myList.iterator();
        myList.clear();
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
